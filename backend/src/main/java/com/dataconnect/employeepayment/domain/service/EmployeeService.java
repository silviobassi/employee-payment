package com.dataconnect.employeepayment.domain.service;

import com.dataconnect.employeepayment.domain.exception.AdvanceMoneyException;
import com.dataconnect.employeepayment.domain.exception.BusinessException;
import com.dataconnect.employeepayment.domain.model.Employee;
import com.dataconnect.employeepayment.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {

    public static final String ALREADY_EXISTS_EMPLOYEE_WITH_CPF = "Já existe um colaborador cadastrado com o cpf: %s.";
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee){
        Optional<Employee> employeeCurrent = employeeRepository.findByCpf(employee.getCpf());

        if(employeeCurrent.isPresent() && !employeeCurrent.get().equals(employeeCurrent)){
            throw new BusinessException(String.format(ALREADY_EXISTS_EMPLOYEE_WITH_CPF, employee.getCpf()));
        }

        employeeRepository.detach(employee);
        return employeeRepository.save(employee);

    }

    @Transactional
    public void delete(Long employeeId){
        try {
            employeeRepository.deleteById(employeeId);
            employeeRepository.flush();

        } catch (EmptyResultDataAccessException e){
            throw new AdvanceMoneyException(employeeId);

        }
    }

    public Employee findOrFail(Long employeeId){
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new AdvanceMoneyException(employeeId));
    }


}
