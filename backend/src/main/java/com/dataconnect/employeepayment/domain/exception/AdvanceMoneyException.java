package com.dataconnect.employeepayment.domain.exception;

public class AdvanceMoneyException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public AdvanceMoneyException(Long advanceMoneyId) {
		super(String.format("Não existe um vale com código %s", advanceMoneyId));
	}
	
}
