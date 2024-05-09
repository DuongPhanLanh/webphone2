package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.cart;
import com.entity.product;

public class cartDAOImpl implements cartDAO {
	
	private Connection conn;
	
	public cartDAOImpl(Connection conn) {
		this.conn=conn;
	}
	
	
	@Override
	public boolean addCart(cart c) {
		boolean f = false;
		try {
			String sql="insert into cart(pid,uid,productname,productcategory,stock,price,totalPrice) values(?,?,?,?,?,?,?)";

			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getPid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getProductname());
			ps.setString(4, c.getProductcategory());
			ps.setInt(5, c.getStock());
			ps.setDouble(6, c.getPrice());
			ps.setDouble(7, c.getTotalprice());
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<cart> getPhoneByUser(int userId) {
	    List<cart> list = new ArrayList<cart>();
	    cart c = null;
	    double totalPrice = 0;
	    try {
	        String sql = "select * from cart where uid=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, userId);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            c = new cart();
	            c.setCid(rs.getInt(1));
	            c.setPid(rs.getInt(2));
	            c.setUid(rs.getInt(3));
	            c.setProductname(rs.getString(4));
	            c.setProductcategory(rs.getString(5));
	            c.setStock(rs.getInt(6));
	            c.setPrice(rs.getDouble(7));
	           // c.setTotalprice(rs.getDouble(8));
	            
	            totalPrice =totalPrice+rs.getDouble(8);
	            c.setTotalprice(totalPrice);
	            list.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	@Override
	public boolean deletePhone(int pid, int uid) {
		boolean f = false;
		try {
			String sql="delete from cart where uid=? and pid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, uid);
			ps.setInt(2, pid);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public  cart getCartById(int ID) {
		cart c = null;
		double totalPrice = 0;
		try {
			String sql = "select * from cart where cid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new cart();
				c.setCid(rs.getInt(1));
	            c.setPid(rs.getInt(2));
	            c.setUid(rs.getInt(3));
	            c.setProductname(rs.getString(4));
	            c.setProductcategory(rs.getString(5));
	            c.setStock(rs.getInt(6));
	            c.setPrice(rs.getDouble(7));
	           // c.setTotalprice(rs.getDouble(8));
	            
	            totalPrice =totalPrice+rs.getDouble(8);
	            c.setTotalprice(totalPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
