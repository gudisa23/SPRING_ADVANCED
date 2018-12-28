package edu.aspire.pojos;
//Withdraw.java
import java.io.Serializable;
/*create  table withdraw(accno number(3)primary key, name varchar2(100), amount number(5));
 *insert into withdraw values(1, 'Ramesh', 500);
 */
public class Withdraw implements Serializable {
	private int accno;
	private String name;
	private int amount;

	public Withdraw() {
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
