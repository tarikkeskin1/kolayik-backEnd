package com.fmss.kolayik.client.dto.request;

import com.fmss.kolayik.model.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UpdateExpenseRequestDto {

    @NotBlank(message = "Haracama türü alanı boş bırakılamaz")
    private ExpenseType expenseType;

    @NotBlank(message = "Haracama miktarı alanı boş bırakılamaz")
    private int expenseAmounth;

    @NotBlank(message = "Fiş tarihi alanı boş bırakılamaz")
    private LocalDate voucherDate;

    @NotBlank(message = "Vergi oranı alanı boş bırakılamaz")
    private int taxRate;

    @NotBlank(message = "Haracama açıklaması alanı boş bırakılamaz")
    private String expensesComment;

}
