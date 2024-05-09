package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.user;

public class userDAOImpl implements userDAO {
private Connection conn;
	
	public userDAOImpl(Connection conn) {
		super();
		this.conn=conn;
	}	
	@Override
	public boolean userRegister(user us) {
		boolean f =false;
		try {
			String sql="insert into user(name, gmail, password, phone) value(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getGmail());
			ps.setString(3, us.getPassword());
			ps.setString(4, us.getPhone());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public user login(String gmail, String password) {
		user us=null;
		try {
			String sql="select * from user where gmail=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gmail);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				us = new user();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setGmail(rs.getString(3));
				us.setPassword(rs.getString(4));
				us.setPhone(rs.getString(5));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

	@Override
	public boolean checkUser(String me) {
		boolean f = true;
		try {
			String sql="select * from user where gmail=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, me);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				f = false;				
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
