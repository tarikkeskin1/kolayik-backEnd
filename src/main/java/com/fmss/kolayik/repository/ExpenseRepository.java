package com.fmss.kolayik.repository;

import com.fmss.kolayik.client.dto.response.ExpensesResponseDto;
import com.fmss.kolayik.model.Expenses;
import com.fmss.kolayik.model.enums.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Long> {



    List<Expenses> findAllByUser_UserId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "update  Expenses e " +
            "set e.expensesComment=:expensesComment, " +
            "e.voucherDate=:voucherDate, " +
            "e.taxRate=:taxRate ," +
            "e.expenseAmounth=:expenseAmounth, " +
            "e.expenseType=:expenseType " +
            "where e.expenseId=:expenseId"
    )
    public void updateExpense(String expensesComment, LocalDate voucherDate, int taxRate, int expenseAmounth, ExpenseType expenseType,Long expenseId);
}