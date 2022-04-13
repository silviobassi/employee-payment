package com.dataconnect.employeepayment.domain.repository;

import com.dataconnect.employeepayment.domain.model.AdvanceMoney;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvanceMoneyRepository extends CustomJpaRepository<AdvanceMoney, Long> {


}