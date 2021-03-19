package com.scglab.iris.apis.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, nullable = false)
	private String email;
	
	@Column(length = 255, nullable = false)
	private String name;
	
	@Column(nullable = false, insertable = true, updatable = false)
	@CreationTimestamp
	private Timestamp createDate;
	
	@Column(nullable = true, insertable = false, updatable = true)
	@UpdateTimestamp
	private Timestamp updateDate;
	
	@JsonIgnore
	@Transient
	private int page;
	
	@JsonIgnore
	@Transient
	private int pageSize;
	
	@JsonIgnore
	@Transient
	private Sort sort;
	
	@Builder
	public UserEntity(String email, String name) {
		this.email = email;
		this.name = name;
	}
	
}
