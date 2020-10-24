package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest 
{
	public static void main(String [] args)
	{
		testAddCartItem();
		testRemoveCartItem();
	}
	
	public static void testAddCartItem()
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.addCartItem(1,103);
		try {
			for(MenuItem m:cartDao.getAllCartItems(1))
			{
				System.out.println(m.toString());
			}
			
		} catch (CartEmptyException e) 
		{
			System.out.println("Empty Cart");
		}
		
	}
	public static void testGetAllCartItems()
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		try {
			for(MenuItem m:cartDao.getAllCartItems(1))
			{
				System.out.println(m.toString());
			}
		} catch (CartEmptyException e) 
		{
			System.out.println("Empty Cart");
		}
	}
	public static void testRemoveCartItem()
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,103);
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) 
		{
			System.out.println("Empty Cart");
		}
		
	}
}
