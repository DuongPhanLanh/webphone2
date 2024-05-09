package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.orderPhone;

public class orderDAOImpl implements orderDAO {

    private Connection conn;
	
	public orderDAOImpl(Connection conn) {
		super();
		this.conn=conn;
	}
	
	@Override
	public int getOrderNo() {
		int i=1;
		try {
			String sql="select * from orderphone";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<orderPhone> getOrderByGmail(String mhgmail) {
		List<orderPhone> list = new ArrayList<orderPhone>();
		orderPhone o = null;
		
		try {
			String sql = "select * from orderphone where ogmail=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mhgmail);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				o = new orderPhone();
				o.setId(rs.getInt(1));
				o.setOid(rs.getString(2));
				o.setOname(rs.getString(3));
				o.setOgmail(rs.getString(4));
				o.setOphone(rs.getString(5));
				o.setOproductname(rs.getString(6));
				o.setOcategory(rs.getString(7));
				o.setOstock(rs.getInt(8));
				o.setOprice(rs.getDouble(9));
				o.setOtotalprice(rs.getDouble(10));
				
				list.add(o);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;		
	}

	@Override
	public List<orderPhone> getAllOrderPhone() {
		List<orderPhone> list = new ArrayList<orderPhone>();
		orderPhone o = null;
		
		try {
			String sql = "select * from orderphone";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				o = new orderPhone();
				o.setId(rs.getInt(1));
				o.setOid(rs.getString(2));
				o.setOname(rs.getString(3));
				o.setOgmail(rs.getString(4));
				o.setOphone(rs.getString(5));
				o.setOproductname(rs.getString(6));
				o.setOcategory(rs.getString(7));
				o.setOstock(rs.getInt(8));
				o.setOprice(rs.getDouble(9));
				o.setOtotalprice(rs.getDouble(10));
				
				list.add(o);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;		
	}

	@Override
	public boolean addOrder(orderPhone o) {
		boolean f = false;
		try {
			String sql ="insert into orderphone(oid,oname,ogmail,ophone,oproduct,ocategory,ostock,oprice,ototalprice) value(?,?,?,?,?,?,?,?,?)";
//			String sql ="INSERT INTO orderphone(oid, oname, ogmail, ophone, oproduct, ocategory, ostock, oprice, ototalprice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn.setAutoCommit(f);
			PreparedStatement ps= conn.prepareStatement(sql);
			
			
				ps.setString(1, o.getOid());
				ps.setString(2, o.getOname());
				ps.setString(3, o.getOgmail());
				ps.setString(4, o.getOphone());
				ps.setString(5, o.getOproductname());
				ps.setString(6, o.getOcategory());
				ps.setInt(7, o.getOstock());
				ps.setDouble(8, o.getOprice());
				ps.setDouble(9, o.getOtotalprice());
				
				
			int i =ps.executeUpdate();
			if(i==1) {
				f=true;
				conn.commit();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

//	@Override
//	public boolean saveOrder(List<orderPhone> plist) {
//		boolean f = false;
//		try {
//			String sql ="insert into orderphone(oid,oname,ogmail,ophone,oproduct,ocategory,ostock,oprice,ototalprice) value(?,?,?,?,?,?,?,?,?)";
//			conn.setAutoCommit(f);
//			PreparedStatement ps= conn.prepareStatement(sql);
//			
//			for(orderPhone o: plist) {
//				ps.setString(1, o.getOid());
//				ps.setString(2, o.getOname());
//				ps.setString(3, o.getOgmail());
//				ps.setString(4, o.getOphone());
//				ps.setString(5, o.getOproductname());
//				ps.setString(6, o.getOcategory());
//				ps.setInt(7, o.getOstock());
//				ps.setDouble(8, o.getOprice());
//				ps.setDouble(9, o.getOtotalprice());
//				
//				ps.addBatch();
//			}
//			int[] count = ps.executeBatch();
//			conn.commit();
//			f=true;
//			conn.setAutoCommit(true);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//	}
	
//	@Override
//	public boolean saveOrder(List<orderPhone> plist) {
//	    boolean f = false;
//	    try {
//	        String sql ="INSERT INTO orderphone(oid, oname, ogmail, ophone, oproduct, ocategory, ostock, oprice, ototalprice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	        conn.setAutoCommit(f);
//	        PreparedStatement ps = conn.prepareStatement(sql);
//
//	        for(orderPhone o: plist) {
//	            ps.setString(1, o.getOid());
//	            ps.setString(2, o.getOname());
//	            ps.setString(3, o.getOgmail());
//	            ps.setString(4, o.getOphone());
//	            ps.setString(5, o.getOproductname());
//	            ps.setString(6, o.getOcategory());
//	            ps.setInt(7, o.getOstock());
//	            ps.setDouble(8, o.getOprice());
//	            ps.setDouble(9, o.getOtotalprice());
//
//	            ps.addBatch();
//	        }
//	        
//	        int[] count = ps.executeBatch();
//	        conn.commit();
//	        f = true;
//	        conn.setAutoCommit(true);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        try {
//	            conn.rollback(); // Rollback trong trường hợp xảy ra lỗi
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        }
//	    }
//	    return f;
//	}
//
//
//	@Override
//	public List<orderPhone> getPhone(String gmail) {
//		List<orderPhone> list = new ArrayList<orderPhone>();
//		orderPhone o = null;
//		
//		try {
//			String sql = "select * from orderphone where ogmail=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, gmail);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				o = new orderPhone();
//				o.setId(rs.getInt(1));
//				o.setOid(rs.getString(2));
//				o.setOname(rs.getString(3));
//				o.setOgmail(rs.getString(4));
//				o.setOphone(rs.getString(5));
//				o.setOproductname(rs.getString(6));
//				o.setOcategory(rs.getString(7));
//				o.setOstock(rs.getInt(8));
//				o.setOprice(rs.getDouble(9));
//				o.setOtotalprice(rs.getDouble(10));
//				
//				list.add(o);
//			}
//					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		return list;		
//	}
//
//	@Override
//	public List<orderPhone> getPhoneForAddmin() {
//		List<orderPhone> list = new ArrayList<orderPhone>();
//		orderPhone o = null;
//		
//		try {
//			String sql = "select * from orderphone";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				o = new orderPhone();
//				o.setId(rs.getInt(1));
//				o.setOid(rs.getString(2));
//				o.setOname(rs.getString(3));
//				o.setOgmail(rs.getString(4));
//				o.setOphone(rs.getString(5));
//				o.setOproductname(rs.getString(6));
//				o.setOcategory(rs.getString(7));
//				o.setOstock(rs.getInt(8));
//				o.setOprice(rs.getDouble(9));
//				o.setOtotalprice(rs.getDouble(10));
//				
//				list.add(o);
//			}
//					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		return list;		
//	}
//	
}
	
	
