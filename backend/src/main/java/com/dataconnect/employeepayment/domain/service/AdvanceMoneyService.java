package com.dataconnect.employeepayment.domain.service;

import com.dataconnect.employeepayment.domain.exception.AdvanceMoneyException;
import com.dataconnect.employeepayment.domain.exception.BusinessException;
import com.dataconnect.employeepayment.domain.exception.EntityInUseException;
import com.dataconnect.employeepayment.domain.model.AdvanceMoney;
import com.dataconnect.employeepayment.domain.model.Employee;
import com.dataconnect.employeepayment.domain.repository.AdvanceMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AdvanceMoneyService {

    public static final String ADVANCE_MONEY_IN_USE =
            "O adiantamento de código %d não pode ser removido, pois está em uso";
    @Autowired
    private AdvanceMoneyRepository advanceMoneyRepository;

    @Autowired
    private EmployeeService employeeService;

    @Transactional
    public AdvanceMoney create(AdvanceMoney advanceMoney){

        Employee employeeCurrent = employeeService.findOrFail(advanceMoney.getEmployee().getId());

        advanceMoneyRepository.detach(advanceMoney);
        advanceMoney.setEmployee(employeeCurrent);
        return advanceMoneyRepository.save(advanceMoney);

    }

    @Transactional
    public void delete(Long advanceMoneyId){
        try {
            advanceMoneyRepository.deleteById(advanceMoneyId);
            advanceMoneyRepository.flush();

        } catch (EmptyResultDataAccessException e){
            throw new AdvanceMoneyException(advanceMoneyId);

        } catch (DataIntegrityViolationException e){
            throw new EntityInUseException(
                    String.format(ADVANCE_MONEY_IN_USE, advanceMoneyId));
        }
    }

    public AdvanceMoney findOrFail(Long advanceMoneyId){
        return advanceMoneyRepository.findById(advanceMoneyId)
                .orElseThrow(() -> new AdvanceMoneyException(advanceMoneyId));
    }

}
