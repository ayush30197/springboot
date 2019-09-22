package com.example.SpringBootDemo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import java.util.List;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
	
	
@RequestMapping(value="/employees",method=RequestMethod.GET,produces="application/json")
public List<Employee> firstPage() {
	List<Employee> employeesList = new ArrayList<Employee>();
    employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
    return employeesList;
}

@RequestMapping(value="/demo",method=RequestMethod.GET,produces="application/json")
public String homePage() throws IOException {
	File file=ResourceUtils.getFile("classpath:config/demo.json");
	String content = new String(Files.readAllBytes(file.toPath()));	
	return content;
}


}
