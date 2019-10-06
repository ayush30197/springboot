package com.example.SpringBootDemo.controller;

public class EmployeeDetails {
String mno;
public String getMno() {
	return mno;
}
public void setMno(String mno) {
	this.mno = mno;
}
public String getAddress() {
	return address;
}
public EmployeeDetails() {
	
}
public EmployeeDetails(String mno, String address) {
	super();
	this.mno = mno;
	this.address = address;
}
public void setAddress(String address) {
	this.address = address;
}
String address;

}
