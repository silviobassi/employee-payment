package com.dataconnect.employeepayment.api.v1.model.output;

import com.dataconnect.employeepayment.domain.model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Relation(collectionRelation = "advance-monies")
@Getter
@Setter
public class AdvanceMoneyModelOutput extends RepresentationModel<AdvanceMoneyModelOutput> {

    private Long id;

    private OffsetDateTime date;

    private BigDecimal value;

    private String description;

    private EmployeeOutput employee;

}
