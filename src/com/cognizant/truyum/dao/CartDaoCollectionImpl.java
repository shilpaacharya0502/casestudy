package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		List<MenuItem> menuItemList;
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId))
		{
			Cart cart =userCarts.get(userId);
			menuItemList=cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			cart.setTotal(cart.getTotal()+menuItem.getPrice());
			userCarts.put(userId, cart);
		}
		else
		{
			menuItemList=new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			userCarts.put(userId, (Cart) menuItemList);
		}
	} 
	

}
