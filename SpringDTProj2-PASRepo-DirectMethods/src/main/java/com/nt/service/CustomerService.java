package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface CustomerService {
	
	public Iterable<CustomerDTO> fetchAllCustomersSortByProperty(String property,boolean asc);
    public Iterable<CustomerDTO> fetchAllCustomersSortByProperties(boolean ascendingOrder,String... properties);
    public Iterable<CustomerDTO> fetchCustomerRecordsByPageNoAndSize(Integer pageNo,Integer pageSize);
}
