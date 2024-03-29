package com.cybertek.controller;

import com.cybertek.datagenerator.DataGenerator;
import com.cybertek.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("statelist", DataGenerator.getStateList());

        return "employee/employee-register";
    }

    @PostMapping("/list")
    public String getEmployeeList(@ModelAttribute("employee") Employee employee, Model model) {

        model.addAttribute("employeelist", Arrays.asList(employee));

        int birthYear = LocalDate.parse(employee.getBirthday()).getYear();
        model.addAttribute("age", LocalDate.now().getYear() - birthYear);
        return "employee/employee-list";
    }
}
