package com.fmss.kolayik.mapper;
import com.fmss.kolayik.client.dto.request.ExpensesRequestDto;
import com.fmss.kolayik.client.dto.response.ExpensesResponseDto;
import com.fmss.kolayik.model.Expenses;
import com.fmss.kolayik.model.User;
import org.springframework.stereotype.Component;

@Component
public class ExpensesMapper {


    public ExpensesResponseDto entityToDto(Expenses expenses){
        ExpensesResponseDto expensesResponseDto=new ExpensesResponseDto();

        expensesResponseDto.setExpenseId(expenses.getExpenseId());
        expensesResponseDto.setUserName(expenses.getUser().getName());
        expensesResponseDto.setSurName(expenses.getUser().getSurName());
        expensesResponseDto.setExpenseType(expenses.getExpenseType());
        expensesResponseDto.setExpenseAmounth(expenses.getExpenseAmounth());
        expensesResponseDto.setVoucherDate(expenses.getVoucherDate());
        expensesResponseDto.setExpensesComment(expenses.getExpensesComment());

      return expensesResponseDto;

    }

    public Expenses dtoToEntity(ExpensesRequestDto expensesRequestDto){
        return  Expenses.builder().user(User.builder().userId(expensesRequestDto.getUserId()).build())
                .expenseType(expensesRequestDto.getExpenseType())
                .expenseAmounth(expensesRequestDto.getExpenseAmounth())
                .voucherDate(expensesRequestDto.getVoucherDate())
                .taxRate(expensesRequestDto.getTaxRate())
                .expensesComment(expensesRequestDto.getExpensesComment())
                .build();
    }
}
