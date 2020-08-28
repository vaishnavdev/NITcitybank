package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;

public interface CustomerService {

	public abstract String addRecord(CustomerDTO dto);
	public abstract String addMultipleRecords(List<CustomerDTO> listDTO);
	public abstract Optional<CustomerDTO> getRecord(Integer id);
    public abstract Iterable<CustomerDTO> getAllRecords();
    public abstract Iterable<CustomerDTO> getAllRecordsById(Iterable<Integer> ids);
	public abstract String deleteRecordById(Integer id);
	public abstract String deleteMultipleRecords(Iterable<Integer> ids) throws Exception;
 
}//interface
