package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public Iterable<CustomerDTO> fetchAllCustomersSortByProperty(String property, boolean asc) {
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList<CustomerDTO>();
		//get sort obj
		Sort sort=null;
		sort=Sort.by(asc?Direction.ASC:Direction.DESC, property);
		//use repo
		itEntities=custRepo.findAll(sort);
		//convert itentities to itdtos and return itdtos
		itEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
		((ArrayList<CustomerDTO>) itDTOs).add(dto);
		});//forEach()
		return itDTOs;
	}//fetchAllCustomersSortByProperty

	@Override
	public Iterable<CustomerDTO> fetchAllCustomersSortByProperties(boolean ascendingOrder, String... entityProperties) {
		
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList<CustomerDTO>();
		//get sort obj
		Sort sort=null;
		sort=Sort.by(ascendingOrder?Direction.ASC:Direction.DESC, entityProperties);
		//use repo
		itEntities=custRepo.findAll(sort);
		//convert itentities to itdtos and return itdtos
		itEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
		((ArrayList<CustomerDTO>) itDTOs).add(dto);
		});//forEach()
		return itDTOs;
	}//fetchAllCustomersSortByProperties(-,-)

	@Override
	public Iterable<CustomerDTO> fetchCustomerRecordsByPageNoAndSize(Integer pageNo, Integer pageSize) {
		Iterable<Customer> itEntities=null;
		Pageable pageable=null;
		Page<Customer> pageEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList<CustomerDTO>();
		//get Pageable Object with given pageNo and pageSize
		pageable=PageRequest.of(pageNo, pageSize);
		//use repo
		pageEntities=custRepo.findAll(pageable);
		System.out.println(pageEntities.getNumberOfElements()+" "+pageEntities.isFirst());
		//convert pageOfEntities to ListOfEntities
		itEntities=pageEntities.getContent();//converts page(entities) to List(entities)
		//convert itEntities to itDTOs and return itDTOs
		itEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
		((ArrayList<CustomerDTO>) itDTOs).add(dto);
		});//forEach()
		return itDTOs;
	}//fetchCustomerRecordsByPageNoAndSize(-,-)

	@Override
	public void fetchCustomerrecordsByPagination(Integer pageSize) {
	    Page<Customer> pageEntities=null;
	    Pageable pageable=null;
		int pagesCount=0;
		int totalNoOfRecords=0;
		int i=0;
		//use repo
		totalNoOfRecords= (int) custRepo.count();
		//get total no of pages that u want to display records per page
		pagesCount=totalNoOfRecords/pageSize;
		pagesCount=totalNoOfRecords%pageSize==0?pagesCount:++pagesCount;
		//get page Obj having records
		for(i=0;i<pagesCount;i++) {
	    //get pageable obj
		pageable=PageRequest.of(i, pageSize);
		//get pageOfEntities
		pageEntities=custRepo.findAll(pageable);
		//convert pageEntities to listDTO
		pageEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			System.out.println(dto);
		});
		System.out.println("Page"+" "+pageEntities.getNumber()+"of"+" "+pageEntities.getTotalPages());
		}//for
		
	}//fetchCustomerrecordsByPagination(-)

}//class
