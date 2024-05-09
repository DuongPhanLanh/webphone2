package com.DAO;

import java.util.List;

import com.entity.cart;

public interface cartDAO {
	
	public boolean addCart(cart c);
	
	public List<cart> getPhoneByUser(int userId);
	
	public boolean deletePhone(int pid, int uid);
	
	public cart getCartById(int ID);
}
