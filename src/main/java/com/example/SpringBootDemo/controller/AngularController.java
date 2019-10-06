package com.example.SpringBootDemo.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AngularController {
ArrayList<String> mgrList = new ArrayList<String>();
ArrayList<String> empList = new ArrayList<String>();
ArrayList<String> locList = new ArrayList<String>();
ArrayList<String> processList = new ArrayList<String>();
ArrayList<String> appList = new ArrayList<String>();
ArrayList<String> missingProcess=new ArrayList<String>();

String mgrName="";
String empName="";
@RequestMapping(value="/cse",method=RequestMethod.GET,produces="application/json")
public ArrayList<String> homePage() throws IOException {
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/testData.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	mgrList.clear();
	for(int i=0;i<array.size();i++)
	{
		
		JsonElement element=array.get(i).getAsJsonObject().get("DirectReports");
		
		JsonArray eleArray=element.getAsJsonArray();
		int size=eleArray.size();
		
		if(size!=0)
		{
			mgrList.add(array.get(i).getAsJsonObject().get("EmployeeName").getAsString());
		}
	}
	
	
	return mgrList;
}

@PostMapping(value="/mgrName")
public void ManagerName(@RequestBody String mgr)
{
	this.mgrName=mgr;
	//System.out.println(mgrName);
}

@RequestMapping(value="/empList",method=RequestMethod.GET,produces="application/json")
public ArrayList<String> empList() throws IOException {
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/testData.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	empList.clear();
	for(int i=0;i<array.size();i++)
	{
		
		JsonElement element=array.get(i).getAsJsonObject().get("EmployeeName");
		if(element.getAsString().equalsIgnoreCase(mgrName))
		{
			JsonArray empArray=array.get(i).getAsJsonObject().get("ExtendendReports").getAsJsonArray();
			for(int j=0;j<empArray.size();j++)
			{
				empList.add(empArray.get(j).getAsString());
			}
		}
		
	}
	

	return empList;
}

@PostMapping(value="/empName")
public void empName(@RequestBody String emp)
{
	this.empName=emp;
	//System.out.println(empName);
}

@RequestMapping(value="/empDetails",method=RequestMethod.GET,produces="application/json")
public EmployeeDetails empDetails() throws IOException {
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/testData.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	
	EmployeeDetails emp=new EmployeeDetails();
	for(int i=0;i<array.size();i++)
	{
		
		JsonElement element=array.get(i).getAsJsonObject().get("EmployeeName");
		if(element.getAsString().equalsIgnoreCase(empName))
		{
			
			emp.setAddress(array.get(i).getAsJsonObject().get("Address").getAsString());
			emp.setMno(array.get(i).getAsJsonObject().get("MobileNo").getAsString());
		}
		
	}
		return emp;
}

@RequestMapping(value="/process",method=RequestMethod.GET,produces="application/json")
public ArrayList<String> processList() throws IOException {
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/process_app.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	processList.clear();
	for(int i=0;i<array.size();i++)
	{
		JsonElement element=array.get(i).getAsJsonObject().get("ProcessName");
		processList.add(element.getAsString());
		
	}
	

	return processList;
}

@RequestMapping(value="/loc",method=RequestMethod.GET,produces="application/json")
public ArrayList<String> locList() throws IOException {
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/locality.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	locList.clear();
	for(int i=0;i<array.size();i++)
	{
		
		locList.add(array.get(i).getAsString());
		
	}
	

	return locList;
}

@RequestMapping(value="/app",method=RequestMethod.GET,produces="application/json")
public ArrayList<String> appList() throws IOException {
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/process_app.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	appList.clear();
	for(int i=0;i<array.size();i++)
	{
		JsonElement element=array.get(i).getAsJsonObject().get("ApplicationName");
		
			JsonArray appArray=element.getAsJsonArray();
			for(int j=0;j<appArray.size();j++)
			{
				String app=appArray.get(j).getAsString();
				
				appList.add(app);
			}
			
		
		
	}
	

	return appList;
}
@PostMapping(value="/processAppList")
public void processList(@RequestBody ProcessAppMap processApp) throws IOException
{
	
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/process_app.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	JsonArray array = new JsonParser().parse(content).getAsJsonArray();
	missingProcess.clear();
	for(int i=0;i<array.size();i++)
	{
		JsonElement element=array.get(i).getAsJsonObject().get("ApplicationName");
		JsonArray appArray=element.getAsJsonArray();
		
		for(int j=0;j<appArray.size();j++)
		{
			
			if(processApp.appL.contains(appArray.get(j).getAsString()))
			{
				String p=array.get(i).getAsJsonObject().get("ProcessName").getAsString();
			
				if(processApp.processL==null)
				{
						missingProcess.add(p);
			
				}
				else if(!(processApp.processL.contains(p)))
			{
				if(!(missingProcess.contains(p)))
			missingProcess.add(p);	
			}
			
			}
			
		}
	}
	
		
}
@RequestMapping(value="/missingProcess",method=RequestMethod.GET,produces="application/json")
public ArrayList<String> sendMissingProcess() throws IOException {
	

	return missingProcess;
}

@PostMapping(value="/newEmployee")
public void newEmployee(@RequestBody NewCriticalSupportEmployee emp) throws IOException
{
	String json=emp.toString();
	JsonObject js=new JsonParser().parse(json).getAsJsonObject();
	File file=ResourceUtils.getFile("../SpringBootDemo/src/main/resources/config/critical_sup_emp.json");
	String content = new String(Files.readAllBytes(file.toPath()));
	FileWriter writer = new FileWriter(file,false);
	
	JsonArray array=new JsonParser().parse(content).getAsJsonArray();
	if(array.size()==0)
	{
		
		array.add(js);
		
	}
	else
	{
		array.add(js);
	}
	
	writer.write(array.toString());
	writer.close();
	
	
}
}
