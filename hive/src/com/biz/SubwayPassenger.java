package com.biz;

public class SubwayPassenger {
	String id;
	int line;
	int passenger;
	
	public SubwayPassenger() {
		
	}
	
	public SubwayPassenger(String id, int line, int passenger) {
	
		this.id = id;
		this.line = line;
		this.passenger = passenger;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getPassenger() {
		return passenger;
	}
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	@Override
	public String toString() {
		return "SubwayPassenger [id=" + id + ", line=" + line + ", passenger=" + passenger + "]";
	}
	

}
