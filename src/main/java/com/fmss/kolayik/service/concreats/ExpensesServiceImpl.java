package com.fmss.kolayik.service.concreats;

import com.fmss.kolayik.client.dto.request.ExpensesRequestDto;
import com.fmss.kolayik.client.dto.request.UpdateExpenseRequestDto;
import com.fmss.kolayik.client.dto.response.ExpensesResponseDto;
import com.fmss.kolayik.exceptions.ExpenseNotFoundException;
import com.fmss.kolayik.mapper.ExpensesMapper;
import com.fmss.kolayik.repository.ExpenseRepository;
import com.fmss.kolayik.service.abstracts.ExpensesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExpensesServiceImpl implements ExpensesService {

    private final ExpenseRepository expenseRepository;
    private final ExpensesMapper expensesMapper;


    public ExpensesServiceImpl(ExpenseRepository expenseRepository, ExpensesMapper expensesMapper) {
        this.expenseRepository = expenseRepository;
        this.expensesMapper = expensesMapper;
    }

    @Override
    public void createExpense(ExpensesRequestDto expensesRequestDto) {
        expenseRepository.save(expensesMapper.dtoToEntity(expensesRequestDto));
    }

    @Override
    public List<ExpensesResponseDto> getAllExpenses() {
        return expenseRepository.findAll().stream().map(expensesMapper::entityToDto).toList();
    }


    @Override
    public List<ExpensesResponseDto> getExpenseByUserId(Long userId) {

        return expenseRepository.findAllByUser_UserId(userId).stream().map(expensesMapper::entityToDto).toList();
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);

    }

    @Override
    public UpdateExpenseRequestDto updateExpense(Long expenseId, UpdateExpenseRequestDto updateExpenseRequestDto) {
        expenseRepository.findById(expenseId).orElseThrow(()->new ExpenseNotFoundException("Expense Bulunamadı"));
        expenseRepository.updateExpense(updateExpenseRequestDto.getExpensesComment(),
                updateExpenseRequestDto.getVoucherDate(),
                updateExpenseRequestDto.getTaxRate(),
                updateExpenseRequestDto.getExpenseAmounth(),
                updateExpenseRequestDto.getExpenseType(),
                expenseId);
        return updateExpenseRequestDto;
    }

}
