package com.dataconnect.employeepayment.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "employees")
public class Employee {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code", updatable = false, unique = true, nullable = false)
    private UUID code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "daily_value", nullable = false)
    private BigDecimal dailyValue;

}