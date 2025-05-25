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
@Table(name = "account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Size(max = 255)
  @NotNull
  @Column(name = "code", nullable = false)
  private String code;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull
  @Column(name = "balance", nullable = false, precision = 19, scale = 2)
  private BigDecimal balance;

//  @Basic
//  @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
//  @Column(name = "activated")
//  private Boolean activated;

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
