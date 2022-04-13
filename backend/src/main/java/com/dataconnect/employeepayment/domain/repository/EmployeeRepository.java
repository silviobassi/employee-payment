package com.dataconnect.employeepayment.domain.repository;

import com.dataconnect.employeepayment.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends CustomJpaRepository<Employee, Long> {

    Optional<Employee> findByCpf(String cpf);
}