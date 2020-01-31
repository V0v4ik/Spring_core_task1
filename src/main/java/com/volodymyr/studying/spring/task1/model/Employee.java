package com.volodymyr.studying.spring.task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;

    private String name;

    private int departmentId;
}
