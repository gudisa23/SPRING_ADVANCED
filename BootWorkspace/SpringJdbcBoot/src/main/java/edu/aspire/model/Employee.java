package edu.aspire.model;
import java.io.Serializable;

/*
 create table employee(eno number(4)primary key, ename varchar2(100), desig varchar2(100), sal number(6,2));
 */
public class Employee implements Serializable {
	private int eno;
	private String ename;
	private String desig;
	private double sal;

	public Employee() {
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

}
