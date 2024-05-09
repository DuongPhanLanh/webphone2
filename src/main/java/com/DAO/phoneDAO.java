package com.DAO;

import java.util.List;

import com.entity.product;

public interface phoneDAO {
public boolean addPhone(product p);
	
	public List<product> AllPhone();
	
	public List<product> ListPhone();
	
	public product getPhoneById(int ID);
	
	public boolean updateEditPhone(product p);
	
	public boolean deletePhone(int id);
	
	
	public List<product> getAllNEW();
	
	public List<product> getAllSALE();
	
	public List<product> getAllDiverse();
	
	public List<product> getPhoneBySearch(String ch);
}
