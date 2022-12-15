package com.fmss.kolayik.controller;

import com.fmss.kolayik.client.dto.request.ExpensesRequestDto;
import com.fmss.kolayik.client.dto.request.UpdateExpenseRequestDto;
import com.fmss.kolayik.client.dto.response.ExpensesResponseDto;
import com.fmss.kolayik.service.abstracts.ExpensesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/expenses")
public class ExpensesController {
    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }


    @PostMapping()
    public boolean createExpense(@RequestBody ExpensesRequestDto expensesRequestDto){
        expensesService.createExpense(expensesRequestDto);
        return true;
    }
    @GetMapping()
    public List<ExpensesResponseDto> getAllExpenses(){
        return expensesService.getAllExpenses();
    }
    @GetMapping("/{userId}")
    public  List<ExpensesResponseDto> getExpenseByUserId(@PathVariable Long userId){
        List<ExpensesResponseDto> expensesResponseDtos=expensesService.getExpenseByUserId(userId);

        return expensesResponseDtos;
    }
    @DeleteMapping("/{expenseId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long expenseId){
        expensesService.deleteExpense(expenseId);
    }

    @PutMapping("/{expenseId}")

    public UpdateExpenseRequestDto updateExpense(@PathVariable Long expenseId,@RequestBody UpdateExpenseRequestDto updateExpenseRequestDto){
      return   expensesService.updateExpense(expenseId,updateExpenseRequestDto);
    }

}
