package com.dataconnect.employeepayment.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AdvanceMoneyModelInput {

    @NotNull
    private OffsetDateTime date;

    @NotNull
    private BigDecimal value;

    @NotBlank
    private String description;

    @NotNull
    private EmployeeInputId employee;

}
