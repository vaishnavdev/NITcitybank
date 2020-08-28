package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * @Id
	 * @GenericGenerator(name="gen1",strategy ="sequence", parameters
	 * =@Parameter(name="sequence_name",value="PID_SEQ") )
	 * 
	 * @GeneratedValue(generator = "gen1")
	 */

	/*
	 * @Id
	 * @GenericGenerator(name="gen1",strategy ="seqhilo", parameters =
	 * {@Parameter(name="sequence_name",value="PID_SEQ"),
	 * 
	 * @Parameter(name="max_lo", value="5") } )
	 */
	/* @GeneratedValue(strategy = GenerationType.AUTO) */
	/*@Id
	@SequenceGenerator(name = "seqGen",sequenceName = "JPA_CUST_SEQ"
	                   ,allocationSize = 2,initialValue = 1)
	@GeneratedValue(generator = "seqGen",strategy = GenerationType.SEQUENCE)*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer cno;
	@Column(nullable = false)
	private String cname;
	@Column(nullable = false)
	private String cadd;
	@Column(nullable = false)
	private Double billAmt;
	
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
