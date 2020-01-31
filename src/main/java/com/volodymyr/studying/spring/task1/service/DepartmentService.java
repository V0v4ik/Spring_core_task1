package com.volodymyr.studying.spring.task1.service;

import com.volodymyr.studying.spring.task1.db.DumbDB;
import com.volodymyr.studying.spring.task1.model.Department;
import com.volodymyr.studying.spring.task1.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentService {

    private EmployeeService employeeService = new EmployeeService();

    public Set<Department> getAllDepartments() {
        return DumbDB.departmentsStorage;
    }

    public Department createNewDepartment(String name) {
        Department department = new Department(DumbDB.departmentCounter++, name);
        getAllDepartments().add(department);
        return department;
    }

    public void updateDepartment(int id, String name) {
        if (getAllDepartments().stream().noneMatch(department -> department.getId() == id)) {
            throw new IllegalArgumentException("Department with id: " + id + " doesn't exist");
        }
        getAllDepartments().stream()
                .filter(department -> department.getId()==id)
                .findFirst()
                .ifPresent(department -> department.setName(name));
    }

    public void assignToDepartment(int departmentId, long employeeId) {
        employeeService.updateEmployee(employeeId, departmentId);
    }

    public List<Employee> getAllEmployeesFromDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .collect(Collectors.toList());
    }
}
