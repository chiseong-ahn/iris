package com.scglab.iris.apis.common;

import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class PageDto {
	private int page;
	private int pageSize;
	private String sortProperty;
	private Direction sortDirection;
}
