package com.dataconnect.employeepayment.api.v1.controller;

import com.dataconnect.employeepayment.api.v1.assembler.AdvanceMoneyAssembler;
import com.dataconnect.employeepayment.api.v1.assembler.AdvanceMoneyDisassembler;
import com.dataconnect.employeepayment.api.v1.model.input.AdvanceMoneyModelInput;
import com.dataconnect.employeepayment.api.v1.model.output.AdvanceMoneyModelOutput;
import com.dataconnect.employeepayment.domain.model.AdvanceMoney;
import com.dataconnect.employeepayment.domain.repository.AdvanceMoneyRepository;
import com.dataconnect.employeepayment.domain.service.AdvanceMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/advance-monies")
public class AdvanceMoneyController {

    @Autowired
    private AdvanceMoneyRepository advanceMoneyRepository;

    @Autowired
    private AdvanceMoneyService advanceMoneyService;

    @Autowired
    private AdvanceMoneyAssembler advanceMoneyAssembler;

    @Autowired
    private AdvanceMoneyDisassembler advanceMoneyDisassembler;

    @Autowired
    private PagedResourcesAssembler<AdvanceMoney> pagedResourcesAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public PagedModel<AdvanceMoneyModelOutput> all(@PageableDefault(size = 10) Pageable pageable){
        Page<AdvanceMoney> advanceMoneyPage = advanceMoneyRepository.findAll(pageable);
        PagedModel<AdvanceMoneyModelOutput> moneyPagedModel = pagedResourcesAssembler
                .toModel(advanceMoneyPage, advanceMoneyAssembler);
        return moneyPagedModel;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AdvanceMoneyModelOutput create(@RequestBody @Valid AdvanceMoneyModelInput advanceMoneyModelInput){
        AdvanceMoney advanceMoney = advanceMoneyDisassembler.toDomainObject(advanceMoneyModelInput);
        advanceMoney = advanceMoneyService.create(advanceMoney);
        return advanceMoneyAssembler.toModel(advanceMoney);

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{advanceMoneyId}")
    public AdvanceMoneyModelOutput update(@PathVariable Long advanceMoneyId,
                                          @RequestBody @Valid AdvanceMoneyModelInput advanceMoneyModelInput){
        AdvanceMoney advanceMoneyCurrent = advanceMoneyService.findOrFail(advanceMoneyId);
        advanceMoneyDisassembler.copyToDomainModel(advanceMoneyModelInput, advanceMoneyCurrent);
        advanceMoneyCurrent = advanceMoneyService.create(advanceMoneyCurrent);

        return advanceMoneyAssembler.toModel(advanceMoneyCurrent);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{advanceMoneyId}")
    public AdvanceMoneyModelOutput findOrFail(@PathVariable Long advanceMoneyId){
        AdvanceMoney advanceMoneyCurrent = advanceMoneyService.findOrFail(advanceMoneyId);
        return advanceMoneyAssembler.toModel(advanceMoneyCurrent);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{advanceMoneyId}")
    public void deleteById(@PathVariable Long advanceMoneyId){
        advanceMoneyService.delete(advanceMoneyId);
    }

}
