/*
CREATE TABLE CUSTOMER(CNO NUMBER(5)PRIMARY KEY, CNAME VARCHAR2(20), ADDRESS VARCHAR2(100), PHONE NUMBER(15));
CREATE SEQUENCE CUSTOMER_SEQ;
*/
package edu.aspire.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({@NamedQuery(name = "cust.findByName", query = "select c from Customer c where c.cname=?") })
public class Customer implements Serializable {
	@Id
	@Column(name = "CNO")
	@SequenceGenerator(name="CUSTOMER_DNO_GENERATOR", sequenceName="CUSTOMER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_DNO_GENERATOR")
	private int cno;
	
	@Column(name = "CNAME")
	private String cname;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE")
	private long phone;

	public Customer() {
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
