package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest 
{
	public static void main(String[] args) 
	{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		
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
	
	public static void testModifyMenuItem()
	{
		try {
			MenuItem mAdd=new MenuItem(102,"Noodles",49,true,DateUtil.convertToDate("23/10/2020"),"Main Course",false);
			MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
			menuItemDao.modifyMenuItem(mAdd);
			System.out.println("After Modification"+menuItemDao.getMenuItem(102));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static void testGetMenuItem()
	{
		
	}
}
