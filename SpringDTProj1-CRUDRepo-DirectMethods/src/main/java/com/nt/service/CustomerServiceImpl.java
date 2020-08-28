package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public String addRecord(CustomerDTO dto) {
		Customer entity=null;
		//convert dto to entity
		entity=new Customer();
		BeanUtils.copyProperties(dto, entity);
		//use repo
		entity=custRepo.save(entity);
		return entity!=null?"Customer details inserted with"
				+ " id"+" "+entity.getCno():"Customer details not inserted";
	}//addRecord(-)

	@Override
	public String addMultipleRecords(List<CustomerDTO> listDTO) {
		List<Customer> listEntities=new ArrayList<Customer>();
		Iterable<Customer> itEntities=null;
		String ids=new String();
		//convert listDTO to listEntities
		listDTO.forEach(dto->{
			Customer entity=new Customer();
			BeanUtils.copyProperties(dto, entity);
			System.out.println(entity);
			listEntities.add(entity);
		});//forEach
		//use repo
		itEntities=custRepo.saveAll(listEntities);
		for(Customer e:itEntities) {
			ids=ids+","+e.getCno();
		}//for
		return itEntities!=null?"Customer's records saved "
				+ "having ids::"+ids:"Customer's records not saved please try again";
	}//addAllRecords(-)

	@Override
	public Optional<CustomerDTO> getRecord(Integer id) {
		Optional<Customer> optEntity=null;
		Optional<CustomerDTO> optDto=null;
		CustomerDTO dto=new CustomerDTO();
		//use repo
		optEntity=custRepo.findById(id);//returns empty Optional Object 
		//without entity object inside optional object if there 
		// is no record found with provided "id" else it returns optional object 
		// with record in the form of Entity object 
		//convert entity obj to dto class obj
		if(optEntity.isPresent()) {
		optDto=Optional.of(dto);
		BeanUtils.copyProperties(optEntity.get(), optDto.get());
		}//if
		else {
			optDto=Optional.empty();
		}//else
		return optDto;
	}//getRecord(-)

	@Override
	public Iterable<CustomerDTO> getAllRecords() {
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList<CustomerDTO>();
		//use repo
		itEntities=custRepo.findAll();
		//convert itEntities to itDto
		if(!((List<Customer>) itEntities).isEmpty())
		itEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<CustomerDTO>) itDTOs).add(dto);
		});//forEach(-)
		return itDTOs;
	}//getAllRecords()

	@Override
	public Iterable<CustomerDTO> getAllRecordsById(Iterable<Integer> ids) {
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList<CustomerDTO>();
		//use repo
		itEntities=custRepo.findAllById(ids);
		//convert itEntities to itDTOs
		itEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<CustomerDTO>) itDTOs).add(dto);
		});//forEach(-)
		return itDTOs;
	}//getAllRecordsById(-)

	@Override
	public String deleteRecordById(Integer id) {
		boolean flag=false;
		//use repo
		flag=custRepo.existsById(id);
		//use repo
		if(flag)
		custRepo.deleteById(id);
		return flag==true?"Customer record have been deleted having"
				+ " id:"+id:"Customer with given"+
				" id:"+id+" "+"does" + "not exist";
	}//deleteRecordById(-)

	@Override
	public String deleteMultipleRecords(Iterable<Integer> ids) {
		Iterable<Customer> itEntities=new ArrayList<Customer>();
		boolean flag=false;
		//use repo
		itEntities=custRepo.findAllById(ids);
		if(!((List<Customer>) itEntities).isEmpty()) {
			System.out.println("entity Objects to be deleted::"+itEntities);
		    flag=true;
		custRepo.deleteAll(itEntities);
		}//if
		return flag==true?"Customers with given id's:"+((List<Customer>) itEntities).get(0)
				.getCno()+","+((List<Customer>) itEntities)
				.get(1).getCno()+" "+"have been "
				+ "deleted":"Customers with any of the given ids does"
				+ " not exists please ensure all the entered id's are correct";
	}//delete
	
}//class
