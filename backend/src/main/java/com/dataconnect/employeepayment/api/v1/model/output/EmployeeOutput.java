package com.dataconnect.employeepayment.api.v1.model.output;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.util.UUID;

@Relation(collectionRelation = "employees")
@Getter
@Setter
public class EmployeeOutput extends RepresentationModel<EmployeeOutput> {

    private Long id;

    private UUID code;

    private String name;

    private String cpf;

    private BigDecimal dailyValue;

}
