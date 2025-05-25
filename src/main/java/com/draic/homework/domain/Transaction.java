package com.draic.homework.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @Column(name = "amount", nullable = false, precision = 19, scale = 2)
  private BigDecimal amount;

  @NotNull
  @Column(name = "transaction_date", nullable = false)
  private Instant transactionDate;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "source_account_id")
  private Account sourceAccount;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "destination_account_id")
  private Account destinationAccount;

  @Size(max = 255)
  @Column(name = "description")
  private String description;

//  @Column(name = "created_at")
//  private Instant createdAt;
//
//  @Column(name = "created_by")
//  private Long createdBy;
//
//  @Column(name = "updated_at")
//  private Instant updatedAt;
//
//  @Column(name = "updated_by")
//  private Long updatedBy;
}
