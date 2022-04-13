package com.dataconnect.employeepayment.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmployeeInputId {

    @NotNull
    private Long id;
}
