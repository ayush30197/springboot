package com.example.SpringBootDemo.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewCriticalSupportEmployee {
	
	String empName;
String mno;
String address;
public NewCriticalSupportEmployee() {
	super();
	// TODO Auto-generated constructor stub
}
public NewCriticalSupportEmployee(String empName, String mno, String address, String locality, String[] processList,
		String[] appList) {
	super();
	this.empName = empName;
	this.mno = mno;
	this.address = address;
	this.locality = locality;
	this.processList = processList;
	this.appList = appList;
}
@Override
public String toString() {
	return "{\"empName\":\"" + empName.toString() + "\", \"mno\":\"" + mno.toString() + "\", \"address\":\"" + address.toString() +
			"\", \"locality\":\""
			+ locality.toString() + "\", \"processList\":[" + 
			Stream.of(processList).collect(Collectors.joining("\",\"", "\"", "\"")) + 
			"],\"appList\":[" + Stream.of(appList).collect(Collectors.joining("\",\"", "\"", "\"")) + "]}";
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getMno() {
	return mno;
}
public void setMno(String mno) {
	this.mno = mno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	
	this.address = address;
}
public String getLocality() {
	return locality;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public String[] getProcessList() {
	return processList;
}
public void setProcessList(String[] processList) {
	
	this.processList = processList;
}
public String[] getAppList() {
	return appList;
}
public void setAppList(String[] appList) {
	this.appList = appList;
}
String locality;
String[] processList;
String[] appList;


}
