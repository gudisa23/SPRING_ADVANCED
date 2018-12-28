package edu.aspire.pojos;

import java.io.Serializable;
/*
 * create  table deposit(accno number(3)primary key, name varchar2(100), amount number(5));
 * insert into deposit  values(1, 'Suresh', 200);
 */
public class Deposit implements Serializable {
	private int accno;
	private String name;
	private int amount;

	public Deposit() {
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
