package com.dataconnect.employeepayment.api.v1.assembler;

import com.dataconnect.employeepayment.api.v1.model.input.AdvanceMoneyModelInput;
import com.dataconnect.employeepayment.domain.model.AdvanceMoney;
import com.dataconnect.employeepayment.domain.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvanceMoneyDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public AdvanceMoney toDomainObject(AdvanceMoneyModelInput advanceMoneyModelInput) {
        return modelMapper.map(advanceMoneyModelInput, AdvanceMoney.class);
    }

    public void copyToDomainModel(AdvanceMoneyModelInput equipmentSupplyInput, AdvanceMoney advanceMoney) {

        //identifier of an instance of com.dataconnect.employeepayment.domain.model.Employee was altered from 1 to 2
        advanceMoney.setEmployee(new Employee());

        modelMapper.map(equipmentSupplyInput, advanceMoney);
    }

}
