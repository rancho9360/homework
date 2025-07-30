package com.draic.homework.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school")
public class School {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "code")
	private String code;

	@Size(max = 255)
	@Column(name = "name")
	private String name;
}