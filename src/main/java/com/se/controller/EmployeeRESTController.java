package com.se.controller;

import com.se.model.EmployeeListVO;
import com.se.model.EmployeeVO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmployeeRESTController
{

    private EmployeeListVO getEmployeesCollection()
    {
        EmployeeListVO employees = new EmployeeListVO();

        EmployeeVO empOne = new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2,"Amit","Singhal","asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3,"Kirti","Mishra","kmishra@gmail.com");


        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);

        return employees;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET ,produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAllEmployeesJSON(Model model)
    {
        model.addAttribute("employees", getEmployeesCollection());
        return "jsonTemplate";
    }
}

