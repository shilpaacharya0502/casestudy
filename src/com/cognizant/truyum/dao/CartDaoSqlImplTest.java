package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest 
{
	public static void main(String [] args) throws ClassNotFoundException, IOException, SQLException, CartEmptyException
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();
		
	}
	public static void testAddCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException
	{
		CartDaoSqlImpl cartDao=new CartDaoSqlImpl();
		cartDao.addCartItem(1, 2);
		for(MenuItem m:cartDao.getAllCartItems(1))
		{
			System.out.println(m.toString());
		}
	}
	public static void testGetAllCartItems() throws ClassNotFoundException, CartEmptyException, IOException, SQLException
	{
		CartDaoSqlImpl cartDao=new CartDaoSqlImpl();
		for(MenuItem m:cartDao.getAllCartItems(1))
		{
			System.out.println(m.toString());
		}
	}
	public static void testRemoveCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException
	{
		CartDaoSqlImpl cartDao=new CartDaoSqlImpl();
		cartDao.removeCartItem(1, 2);
		for(MenuItem m:cartDao.getAllCartItems(1))
		{
			System.out.println(m.toString());
		}
	}
	
}
