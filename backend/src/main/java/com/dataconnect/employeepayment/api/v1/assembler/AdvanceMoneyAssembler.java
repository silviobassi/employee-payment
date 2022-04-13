package com.dataconnect.employeepayment.api.v1.assembler;

import com.dataconnect.employeepayment.api.v1.controller.AdvanceMoneyController;
import com.dataconnect.employeepayment.api.v1.model.output.AdvanceMoneyModelOutput;
import com.dataconnect.employeepayment.domain.model.AdvanceMoney;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvanceMoneyAssembler extends RepresentationModelAssemblerSupport<AdvanceMoney, AdvanceMoneyModelOutput> {

        @Autowired
        private ModelMapper modelMapper;

    public AdvanceMoneyAssembler() {
        super(AdvanceMoneyController.class, AdvanceMoneyModelOutput.class);
    }

        public AdvanceMoneyModelOutput toModel(AdvanceMoney advanceMoney) {
            return modelMapper.map(advanceMoney, AdvanceMoneyModelOutput.class);
        }

        public List<AdvanceMoneyModelOutput> toCollectionModel(List<AdvanceMoney> equipment) {
            return equipment.stream().map(this::toModel)
                    .collect(Collectors.toList());
        }

}
