package com.scglab.iris.apis.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class PageService {

	public Pageable getPageable(PageDto pageDto) {
		List<Order> orders = new ArrayList<Order>();
		
		if(pageDto.getSortProperty() != null) {
			Order order = null;
			if(pageDto.getSortDirection() == null) {
				order = Order.asc(pageDto.getSortProperty());
			}else {
				order = new Order(pageDto.getSortDirection(), pageDto.getSortProperty());
			}
			orders.add(order);
		}
		
		pageDto.setPage(pageDto.getPage() == 0 ? 1 : pageDto.getPage());
		pageDto.setPageSize(pageDto.getPageSize() == 0 ? 100 : pageDto.getPageSize());
		
		return PageRequest.of(pageDto.getPage() - 1, pageDto.getPageSize(), Sort.by(orders));
	}
}
