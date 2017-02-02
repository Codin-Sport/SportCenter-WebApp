package me.nichel.sportcenter.model;

import java.time.LocalDateTime;

public class Reservation {

	private long id;
	private long customer_id;
	private long field_id;
	
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private LocalDateTime ctime;
	private LocalDateTime utime;
	
	private String info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getField_id() {
		return field_id;
	}

	public void setField_id(long field_id) {
		this.field_id = field_id;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public LocalDateTime getCtime() {
		return ctime;
	}

	public void setCtime(LocalDateTime ctime) {
		this.ctime = ctime;
	}

	public LocalDateTime getUtime() {
		return utime;
	}

	public void setUtime(LocalDateTime utime) {
		this.utime = utime;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	
	
}
