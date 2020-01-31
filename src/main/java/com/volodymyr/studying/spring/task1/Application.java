package com.volodymyr.studying.spring.task1;

import com.volodymyr.studying.spring.task1.db.DumbDB;
import com.volodymyr.studying.spring.task1.service.DepartmentService;
import com.volodymyr.studying.spring.task1.service.EmployeeService;

public class Application {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        DepartmentService departmentService = new DepartmentService();
        System.out.println(employeeService.createNewEmployee("John"));
        System.out.println(employeeService.updateEmployee(0, 11));
        System.out.println(departmentService.createNewDepartment("QA"));
        System.out.println(departmentService.createNewDepartment("BA"));
        DumbDB.employeesStorage.forEach(System.out::println);

    }
}
