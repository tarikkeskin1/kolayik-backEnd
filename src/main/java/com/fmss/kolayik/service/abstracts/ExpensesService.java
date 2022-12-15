package com.fmss.kolayik.service.abstracts;

import com.fmss.kolayik.client.dto.request.ExpensesRequestDto;
import com.fmss.kolayik.client.dto.request.UpdateExpenseRequestDto;
import com.fmss.kolayik.client.dto.response.ExpensesResponseDto;

import java.util.List;

public interface ExpensesService {
    void createExpense(ExpensesRequestDto expensesRequestDto);
    List<ExpensesResponseDto> getAllExpenses ();

    List<ExpensesResponseDto> getExpenseByUserId(Long userId);
    void deleteExpense(Long expenseId);

    UpdateExpenseRequestDto updateExpense(Long expenseId, UpdateExpenseRequestDto updateExpenseRequestDto);
}
