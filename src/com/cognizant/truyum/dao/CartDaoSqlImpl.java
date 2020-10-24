package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl 
{
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException
	{
		Connection con=ConnectionHandler.getConnection();
		Cart cart=new Cart(new ArrayList<MenuItem>(),0);
		String sql="select * from cart INNER JOIN menu_item on cart.ct_menu_id=menu_item.me_id WHERE cart.user_id=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, userId);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) 
		{ 
			
		}
		return null;
		
	}
	
	public void addCartItem(long userId ,long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection con=ConnectionHandler.getConnection();
		String sql="INSERT INTO cart values(?,?);";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, userId);
		ps.setLong(2, menuItemId);
		ps.executeQuery();
		
	}
	public void removeCartItem( long userId,long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection con=ConnectionHandler.getConnection();
		String sql="DELETE from cart where user_id=? and menuItemId=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, userId);
		ps.setLong(2, menuItemId);
		ps.executeQuery();
	}
}