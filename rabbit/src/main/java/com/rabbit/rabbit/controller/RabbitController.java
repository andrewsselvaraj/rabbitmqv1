package com.rabbit.rabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.rabbit.model.Employee;
import com.rabbit.rabbit.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	String s = "Message sent to the RabbitMQ JavaInUse Successfully";
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		try {
			rabbitMQSender.send(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s=e.getMessage();
		}

		return s;
	}

}
