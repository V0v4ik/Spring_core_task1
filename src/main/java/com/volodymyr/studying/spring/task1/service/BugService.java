package com.volodymyr.studying.spring.task1.service;

import com.volodymyr.studying.spring.task1.db.DumbDB;
import com.volodymyr.studying.spring.task1.model.Bug;

import java.util.List;

public class BugService {

    private final int NO_USER_ID = -1;
    private EmployeeService employeeService = new EmployeeService();

    public List<Bug> getAllBugs() {
        return DumbDB.bugsStorage;
    }

    public Bug createBug(String description) {
        Bug newBug = new Bug(DumbDB.bugCounter++, description, NO_USER_ID);
        getAllBugs().add(newBug);
        return newBug;
    }

    public Bug createBug(String description, long userId) {
        if (DumbDB.employeesStorage.stream().noneMatch(employee -> employee.getId()==userId)) {
            throw new IllegalArgumentException("User with id: " + userId + " doesn't exist");
        }
        Bug newBug = new Bug(DumbDB.bugCounter++, description, userId);
        getAllBugs().add(newBug);
        return newBug;
    }

    public void updateBug(long id, String description) {
        if(getAllBugs().stream().noneMatch(bug -> bug.getId()==id)) {
            throw new IllegalArgumentException("Bug with id: " + id + " doesn't exist");
        }
        getAllBugs().stream()
                .filter(bug -> bug.getId()==id)
                .findFirst()
                .ifPresent(bug -> bug.setDescription(description));
    }

    public void assignToUser(long bugId, long userId) {
        if(getAllBugs().stream().noneMatch(bug -> bug.getId()==bugId)) {
            throw new IllegalArgumentException("Bug with id: " + bugId + " doesn't exist");
        }
        if (DumbDB.employeesStorage.stream().noneMatch(employee -> employee.getId()==userId)) {
            throw new IllegalArgumentException("User with id: " + userId + " doesn't exist");
        }
        getAllBugs().stream()
                .filter(bug -> bug.getId()==bugId)
                .findFirst()
                .ifPresent(bug -> bug.setUserId(userId));
    }
}
