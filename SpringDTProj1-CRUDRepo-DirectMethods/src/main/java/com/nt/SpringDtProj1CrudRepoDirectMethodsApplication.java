package com.nt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;

@SpringBootApplication
public class SpringDtProj1CrudRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerService service = null;
		String result, result1 = null;
		CustomerDTO dto, dto1, dto2, dto3 = null;
		List<CustomerDTO> listDTO = null;
		Optional<CustomerDTO> optDto = null;
		Iterable<CustomerDTO> itDTOs, itDTOs1 = null;
		Iterable<Integer> ids = null;
		Scanner scn = null;
		String result3, result4 = null;
		//get conteiner
		ctx = SpringApplication.run(SpringDtProj1CrudRepoDirectMethodsApplication.class, args);
		//get service class obj
		service = ctx.getBean("custService", CustomerService.class);
		/*//create dto class obj
		dto=new CustomerDTO();
		dto.setCname("vaishnavdev");
		dto.setCadd("hyd");
		dto.setBillAmt(25000.0);
		//use service
		try {
		    result=service.addRecord(dto);
		    System.out.println("Customer Insertion history::"+" "+result);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//catch
		System.out.println(".......................................");
		//insert all operation
		dto1=new CustomerDTO();
		dto2=new CustomerDTO();
		dto3=new CustomerDTO();
		dto1.setCname("hyndavi"); dto1.setCadd("hyd"); dto1.setBillAmt(20000.0);
		dto2.setCname("aneesh"); dto2.setCadd("hyd"); dto2.setBillAmt(30000.0);
		dto3.setCname("raj"); dto3.setCadd("hyd"); dto3.setBillAmt(450000.0);
		listDTO=new ArrayList<CustomerDTO>();
		listDTO.add(dto1);listDTO.add(dto2);listDTO.add(dto3);
		try {
			result1=service.addMultipleRecords(listDTO);
			System.out.println(result1);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//catch
		      //select by id operation
		try {
			optDto=service.getRecord(77);
			if(optDto!=null && optDto.isPresent()) {
			    System.out.println("Customer record found::"+optDto.get().toString());
			}//if
			else {
				System.out.println("Customer record not found");
			}//else
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		      //select all operation
		try {
			itDTOs=service.getAllRecords();
			itDTOs.forEach(System.out::println);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//catch
		    //selectMultipleRecordsById
		
		itDTOs=service.getAllRecordsById(List.of(new Integer(10),new Integer(20),
			   new Integer(30)));//java 9 feature(List.of)
		scn = new Scanner(System.in);
		System.out.println("Enter 1st customer id::");
		Integer i1 = scn.nextInt();
		System.out.println("Enter 2nd customer id::");
		Integer i2 = scn.nextInt();
		System.out.println("Enter 3rd customer id::");
		Integer i3 = scn.nextInt();
		//create Integer objects
		Integer id1 = new Integer(i1);
		Integer id2 = new Integer(i2);
		Integer id3 = new Integer(i3);
		//create List Collection
		ids=new ArrayList<Integer>();
		((List<Integer>) ids).add(id1);
		((List<Integer>) ids).add(id2);
		((List<Integer>) ids).add(id3);
		try {
			itDTOs = service.getAllRecordsById(ids);
			itDTOs.forEach(System.out::println);
		} //try
		catch (DataAccessException dae) {
			dae.printStackTrace();
		} //catch
		 try {
			result3 = service.deleteRecordById(20);
			System.out.println("Deletion History::" + result3);
		} //try
		catch (Exception e) {
			e.printStackTrace();
		} //catch
		*/ 
		scn = new Scanner(System.in);
		System.out.println("Enter 1st customer id to be deleted::");
		Integer i1 = scn.nextInt();
		System.out.println("Enter 2nd customer id to be deleted::");
		Integer i2 = scn.nextInt();
		System.out.println("Enter 3rd customer id to be deleted::");
		Integer i3 = scn.nextInt();
		//create Integer objects
		Integer id1 = new Integer(i1);
		Integer id2 = new Integer(i2);
		Integer id3 = new Integer(i3);
		//create List Collection and Integer Objects to ListCollection
		ids=new ArrayList<Integer>();
		((List<Integer>) ids).add(id1);
		((List<Integer>) ids).add(id2);
		((List<Integer>) ids).add(id3);
		try {
			result4 = service.deleteMultipleRecords(ids);
			System.out.println(result4);
		} //try
		catch (DataAccessException dae) {
			dae.printStackTrace();
		} //catch
		catch (Exception e) {
			e.printStackTrace();
		} //catch
			//close scanner
		scn.close();
	}//main(-)

}//class
