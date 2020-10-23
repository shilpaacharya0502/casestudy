package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest 
{
	public static void main(String[] args) 
	{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
	}

	public static void testGetMenuItemListAdmin() 
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// menuItemDao.getMenuItemListAdmin();
		for (MenuItem m : menuItemDao.getMenuItemListAdmin()) 
		{
			System.out.print(m.toString());
		}
	}

	public static void testGetMenuItemListCustomer() 
	{
		MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
		
		for (MenuItem m : menuItemDao.getMenuItemListCustomer()) 
		{
			System.out.print(m.toString());
		}
	}
}
