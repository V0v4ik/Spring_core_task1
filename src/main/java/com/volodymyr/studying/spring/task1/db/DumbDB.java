package com.volodymyr.studying.spring.task1.db;

import com.volodymyr.studying.spring.task1.model.Bug;
import com.volodymyr.studying.spring.task1.model.Department;
import com.volodymyr.studying.spring.task1.model.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DumbDB {

    public static List<Employee> employeesStorage = new ArrayList<>();

    public static long employeeCounter;

    public static Set<Department> departmentsStorage = new HashSet<>();

    public static int departmentCounter;

    public static List<Bug> bugsStorage = new ArrayList<>();

    public static int bugCounter;
}
