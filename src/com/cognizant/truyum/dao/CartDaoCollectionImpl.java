package com.cognizant.truyum.dao;

import java.util.HashMap;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl //implements CartDao
{
	private static HashMap<Long, Cart> userCarts;
	 
	public CartDaoCollectionImpl()
	{
		super();
		if(userCarts==null)
		{
			userCarts= new HashMap<Long, Cart>();
			
		}
	}
	
	public void addCartItem(long userId,long menuItemId)
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId))
		{
			
		}
	}
}
