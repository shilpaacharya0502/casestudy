package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao
{
	private List<MenuItem> menuItemList=new ArrayList<>();
	private List<MenuItem> menuItemListC=new ArrayList<>();
	
	public List<MenuItem> getMenuItemListAdmin() 
	{
		return menuItemList;
	}
	
	public void MenuItemDaoCollectionImpl() // not sure 
	{
		
	}
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime();
		for(MenuItem m:menuItemListC)
		{
			int i=0;
			if((m.getDateOfLaunch().compareTo(today))==0||m.getDateOfLaunch().before(today)==true)
			{
				if(m.isActive()==true)
				{
					
				}
			}
		}
		
		return menuItemListC;
	}
}
