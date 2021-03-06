package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao
{
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException
	{
		List<MenuItem> menuIteml= new ArrayList<>();
		String sql="SELECT * FROM menu_item;";
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) 
		{ 
			MenuItem m=new MenuItem(rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5), sql, false);
			menuIteml.add(m);
		}
		return menuIteml;
		
	}
	@Override
	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException 
	{
		List<MenuItem> menuIteml= new ArrayList<>();
		String sql="SELECT * FROM menu_item where me_active=1 and me_dol<=CURDATE(); ";
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		//ps.setDate(5, rs.g, cal);  //wrong
		
		while (rs.next()) 
		{ 
			MenuItem m=new MenuItem(rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5), sql, false);
			menuIteml.add(m);
		}
		return menuIteml;
		
	}
	
	
	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		String sql="SELECT * FROM menu_item where me_id=?; ";
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, menuItemId);
		ResultSet rs=ps.executeQuery();
		rs.first();
		MenuItem m=new MenuItem(rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5), sql, false);
		return m;
		
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException 
	{
		String sql="UPDATE menu_item SET me_name=?,me_price=?,me_active=?,me_dol=? where me_id=?;";
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, menuItem.getName());
		ps.setFloat(2, menuItem.getPrice());
		ps.setBoolean(3, menuItem.isActive());
		ps.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
		ps.setLong(5, menuItem.getId());
		ps.executeQuery();
		
	}

}
