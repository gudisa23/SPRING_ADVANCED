package com.brownfield.pss.checkin.component;

import java.util.Date;
import java.util.Set;

public class BookingRecord {
	long id;
	private String status;


	public BookingRecord() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BookingRecord [id=" + id + ", Status=" + status + "]";
	}
}
