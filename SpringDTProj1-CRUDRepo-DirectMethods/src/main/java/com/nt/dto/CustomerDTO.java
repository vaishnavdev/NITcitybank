package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer cno;
	private String cname;
	private String cadd;
	private Double billAmt;
	
	/*public CustomerDTO(Integer cno) {
		this.cno=cno;
	}*/
	
	//setters and getters
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public Double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]";
	}//toString()

}//class
