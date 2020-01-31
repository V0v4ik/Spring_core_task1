package com.volodymyr.studying.spring.task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bug {

    private long id;

    private String description;

    private long userId;
}
