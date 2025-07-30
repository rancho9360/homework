package com.draic.homework.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "code")
	private String code;

	@Size(max = 255)
	@Column(name = "name")
	private String name;


	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private Set<Student> students =  new HashSet<>();



}