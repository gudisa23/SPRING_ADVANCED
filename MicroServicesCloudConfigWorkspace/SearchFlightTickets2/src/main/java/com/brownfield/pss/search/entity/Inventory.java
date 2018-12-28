package com.brownfield.pss.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Inventory {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name="INVENTORY_ID_GENERATOR", sequenceName="INVENTORY_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVENTORY_ID_GENERATOR")
    @Column(name = "inv_id")
	long id;
    
    int count;
    
 
    public Inventory() {
		super();
	}

	public Inventory(int count) {
		super();
		this.count = count;
	}

 
 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", count=" + count + "]";
	}
    
    
}
