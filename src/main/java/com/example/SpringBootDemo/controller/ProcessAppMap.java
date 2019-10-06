package com.example.SpringBootDemo.controller;

import java.util.Arrays;
import java.util.List;

public class ProcessAppMap {
List processL;
public ProcessAppMap(List processL, List appL) {
	super();
	this.processL = processL;
	this.appL = appL;
}
public ProcessAppMap() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ProcessAppMap [processL=" + processL + ", appL=" + appL + "]";
}
List appL;
public List getProcessL() {
	return processL;
}
public void setProcessL(List processL) {
	this.processL = processL;
}
public List getAppL() {
	return appL;
}
public void setAppL(List appL) {
	this.appL = appL;
}

}
