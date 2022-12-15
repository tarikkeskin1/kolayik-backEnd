package com.fmss.kolayik.client.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmss.kolayik.model.enums.ExpenseType;
import lombok.*;

import javax.persistence.Enumerated;
import java.time.LocalDate;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesResponseDto {

//    private int taxRate;
//    private Long expenseId;
     private Long expenseId;

    private  String userName;
    private  String surName;

    private ExpenseType expenseType;

    private int expenseAmounth;

    private LocalDate voucherDate;

    private String expensesComment;





}
