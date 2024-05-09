package com.DAO;

import java.util.List;

import com.entity.orderPhone;

public interface orderDAO {
	public int getOrderNo();
	
//	public boolean saveOrder(List<orderPhone> plist);
//	
//	public List<orderPhone> getPhone(String gmail);
//	
//	public List<orderPhone> getPhoneForAddmin();
	
	public boolean addOrder(orderPhone o);
	
	public List<orderPhone> getOrderByGmail(String mhgmail);
	
	public List<orderPhone> getAllOrderPhone();
	
}
