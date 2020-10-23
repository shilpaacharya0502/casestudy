package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao
{
	private static List<MenuItem> menuItemList;
	private List<MenuItem> menuItemListC=new ArrayList<>();
	
	public List<MenuItem> getMenuItemListAdmin() 
	{
		return menuItemList;
	}
	
	public MenuItemDaoCollectionImpl()
	{
		if(menuItemList==null)
		{
			menuItemList=new ArrayList<MenuItem>();
			
			try {
				menuItemList.add(new MenuItem(101,"Sandwich",99,true,DateUtil.convertToDate("15/03/2017"),"Main Course",true));
				menuItemList.add(new MenuItem(102,"Burger",129,true,DateUtil.convertToDate("23/12/2017"),"Main Course",false));
				menuItemList.add(new MenuItem(103,"Pizza",149,true,DateUtil.convertToDate("21/08/2018"),"Main Course",false));
				menuItemList.add(new MenuItem(104,"French fries",57,false,DateUtil.convertToDate("02/07/2017"),"Starters",true));
				menuItemList.add(new MenuItem(105,"Chocolat Brownie",32,true,DateUtil.convertToDate("02/11/2022"),"Dessert",true));
			} catch (ParseException e) 
			{
				e.printStackTrace();
			}	
		}
	}
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		Date today = Calendar.getInstance().getTime();
		for(MenuItem m:menuItemList)
		{
			if((m.getDateOfLaunch().compareTo(today))==0||m.getDateOfLaunch().before(today)==true) //check
			{
				if(m.isActive()==true)
				{
					menuItemListC.add(m);
				}
			}
		}
		
		return menuItemListC;
	}
	
	
	public void modifyMenuItem(MenuItem menuItem)
	{
		for(MenuItem m:menuItemList)
		{
			if(m.getId()==menuItem.getId())
			{
				m.setName(menuItem.getName());
				m.setPrice(menuItem.getPrice());
				m.setActive(menuItem.isActive());
				m.setDateOfLaunch(menuItem.getDateOfLaunch());
				m.setCategory(menuItem.getCategory());
				m.setFreeDelivery(menuItem.isFreeDelivery());
			}
		}
	}
	
	public MenuItem getMenuItem(long menuItemId)
	{
		MenuItem item = null;
		for(MenuItem m:menuItemList)
		{
			if(m.getId()==menuItemId)
			{
				
			}
		}
		return item;
	}
}
