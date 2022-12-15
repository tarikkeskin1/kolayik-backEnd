package com.fmss.kolayik.client.dto.request;

import com.fmss.kolayik.model.enums.ExpenseType;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesRequestDto {

    @NotNull(message = "User id must not be null")
    private Long userId;

    @NotBlank(message = "Haracama türü alanı boş bırakılamaz")
    private ExpenseType expenseType;

    @NotBlank(message = "Haracama miktarı alanı boş bırakılamaz")
    private int expenseAmounth;

    @NotBlank(message = "Haracama tarihi alanı boş bırakılamaz")
    private LocalDate voucherDate;

    @NotBlank(message = "Vergi  alanı boş bırakılamaz")
    private int taxRate;

    @NotBlank(message = "Haracama açıklaması alanı boş bırakılamaz")
    private String expensesComment;

}
