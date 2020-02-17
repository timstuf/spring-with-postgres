package com.nix.spring.test.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "id")
    private Long employeeId;
    @Column
    private String name;

    public Employee(@JsonProperty("employeeId") Long employeeId,
                    @JsonProperty("name") String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
}

