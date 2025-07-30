package com.draic.homework.pojo.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class RoomPo {
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