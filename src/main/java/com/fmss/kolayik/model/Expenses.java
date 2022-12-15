package com.fmss.kolayik.model;

import com.fmss.kolayik.model.enums.ExpenseType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Builder
@Table(name="expenses")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Expenses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="expense_id",nullable = false)

    private Long expenseId;

    @Column(name="expense_type",nullable = false)
    @Enumerated(EnumType.STRING)
   private ExpenseType expenseType;

    @Column(name="expense_amounth",nullable = false)
   private int expenseAmounth;

    @Column(name="voucher",nullable = false)
   private LocalDate voucherDate;

    @Column(name="tax_rate",nullable = false)
   private int taxRate;

    @Column(name="expenses_comment",nullable = false)
   private String expensesComment;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;




}
