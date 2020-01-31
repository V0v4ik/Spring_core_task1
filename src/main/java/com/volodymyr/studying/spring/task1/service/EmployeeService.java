package com.volodymyr.studying.spring.task1.service;

import com.volodymyr.studying.spring.task1.db.DumbDB;
import com.volodymyr.studying.spring.task1.model.Employee;

import java.util.List;

public class EmployeeService {
    private final int NO_DEPARTMENT_ID = -1;

    public List<Employee> getAllEmployees() {
        return DumbDB.employeesStorage;
    }

    //creating new employee that has no department yet
    public Employee createNewEmployee(String name) {
        Employee newEmployee = new Employee(DumbDB.employeeCounter++, name, NO_DEPARTMENT_ID);
        getAllEmployees().add(newEmployee);
        return newEmployee;
    }

    public Employee createNewEmployee(String name, int departmentId) {
        if (DumbDB.departmentsStorage.stream().noneMatch(department -> department.getId() == departmentId)) {
            throw new IllegalArgumentException("Department with id: " + departmentId + " doesn't exist");
        }
        Employee newEmployee = new Employee(DumbDB.employeeCounter, name, departmentId);
        getAllEmployees().add(newEmployee);
        DumbDB.employeeCounter++;
        return newEmployee;
    }

    public void updateEmployee(long id, int departmentId) {
        if (DumbDB.departmentsStorage.stream().noneMatch(department -> department.getId() == departmentId)) {
            throw new IllegalArgumentException("Department with id: " + departmentId + " doesn't exist");
        }
        if (getAllEmployees().stream().noneMatch(employee -> employee.getId()==id)) {
            throw new IllegalArgumentException("User with id: " + id + " doesn't exist");
        }
        //ifPresentOrElse works from Java 9, so this code looks not as good as I'd like
        getAllEmployees().stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .ifPresent(employee -> employee.setDepartmentId(departmentId));
    }
}
