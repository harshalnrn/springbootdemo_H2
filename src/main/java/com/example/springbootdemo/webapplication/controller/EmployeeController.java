package com.example.springbootdemo.webapplication.controller;

import com.example.springbootdemo.webapplication.POJO.EmployeePojo;
import com.example.springbootdemo.webapplication.repository.Employee;
import com.example.springbootdemo.webapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listOfEmployees() {
        return this.employeeRepository.findAll();
    }

    /* List added employees. */
    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET, produces = "application/json")
    public EmployeePojo listEmployeeList() {

        EmployeePojo bean = new EmployeePojo();
        bean.employeeList = listOfEmployees(); //get the list of employees from jpa
       // model.addAttribute("bean", bean);
      //  return model;
        return bean;
        //return "listEmployee";
    }

    /* *//* Display add employee form page. *//*
    @RequestMapping(value="/addEmployeePage", method=RequestMethod.GET)
    public String addEmployeePage() {
        return "addEmployee";
    }*/


    /* Below method gets called on submit in add form. Add user submitted employee info to h2 databae and redirect to list employees page. */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST, produces = "application/json")
    public EmployeePojo addEmployee( @RequestBody  EmployeePojo employeePojo) {
        //populate entity object from pojo:
        Employee employeeDto = new Employee();
        EmployeePojo pojo = new EmployeePojo();
        employeeDto.setUserName(employeePojo.getUserName());
        employeeDto.setAge(employeePojo.getAge());
        employeeDto.setEmail(employeePojo.getEmail());
        employeeDto.setPassword(employeePojo.getPassword());
        employeeDto.setId(employeePojo.getId());
        employeeDto.setSex(employeePojo.getSex());
        employeeDto.setSalary(employeePojo.getSalary());
        employeeDto.setTitle(employeePojo.getTitle());

        employeeDto = employeeRepository.save(employeeDto);

        // return "redirect:/employee/listEmployee";

        pojo.setAge(employeeDto.getAge());
        pojo.setEmail(employeeDto.getEmail());
        pojo.setId(employeeDto.getId());
        pojo.setPassword(employeeDto.getPassword());
        pojo.setSalary(employeeDto.getSalary());
        pojo.setSex(employeeDto.getSex());
        pojo.setTitle(employeeDto.getTitle());
        pojo.setUserName(employeeDto.getUserName());

        //model.addAttribute("model", pojo);
       // return model;
        return pojo;
    }

}


// what if i dont return anything from controller. will the flow reach back to view .ie. save data and get back to refreshed same view?
// No. it can eighter return a string or an object, where if its just page refresh, return page name as string