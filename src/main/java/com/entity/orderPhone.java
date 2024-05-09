package com.entity;

public class orderPhone {
	private int id; 
	private String oid;
	
	private String oname;
	private String ogmail;
	private String ophone;
	
	private String oproductname;
	private String ocategory;	
	private int ostock;
	private double oprice;
	
	private double ototalprice;
	
	public orderPhone() {
		// TODO Auto-generated constructor stub
	}

	public orderPhone(int id, String oid, String oname, String ogmail, String ophone, String oproductname,
			String ocategory, int ostock, double oprice, double ototalprice) {
		super();
		this.id = id;
		this.oid = oid;
		this.oname = oname;
		this.ogmail = ogmail;
		this.ophone = ophone;
		this.oproductname = oproductname;
		this.ocategory = ocategory;
		this.ostock = ostock;
		this.oprice = oprice;
		this.ototalprice = ototalprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOgmail() {
		return ogmail;
	}

	public void setOgmail(String ogmail) {
		this.ogmail = ogmail;
	}

	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public String getOproductname() {
		return oproductname;
	}

	public void setOproductname(String oproductname) {
		this.oproductname = oproductname;
	}

	public String getOcategory() {
		return ocategory;
	}

	public void setOcategory(String ocategory) {
		this.ocategory = ocategory;
	}

	public int getOstock() {
		return ostock;
	}

	public void setOstock(int ostock) {
		this.ostock = ostock;
	}

	public double getOprice() {
		return oprice;
	}

	public void setOprice(double oprice) {
		this.oprice = oprice;
	}

	public double getOtotalprice() {
		return ototalprice;
	}

	public void setOtotalprice(double ototalprice) {
		this.ototalprice = ototalprice;
	}

	@Override
	public String toString() {
		return "orderPhone [id=" + id + ", oid=" + oid + ", oname=" + oname + ", ogmail=" + ogmail + ", ophone="
				+ ophone + ", oproductname=" + oproductname + ", ocategory=" + ocategory + ", ostock=" + ostock
				+ ", oprice=" + oprice + ", ototalprice=" + ototalprice + "]";
	}
	
	
	
}
