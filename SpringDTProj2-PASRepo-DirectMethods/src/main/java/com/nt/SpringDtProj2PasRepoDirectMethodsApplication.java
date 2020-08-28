package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;

@SpringBootApplication
public class SpringDtProj2PasRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerService service=null;
		Iterable<CustomerDTO> itDTOs,itDTOs1,itDTOs3=null;
		//get container
		ctx=SpringApplication.run(SpringDtProj2PasRepoDirectMethodsApplication.class, args);
	    //get service class object
		service=ctx.getBean("custService", CustomerService.class);
		//invoke method
		try {
			itDTOs=service.fetchAllCustomersSortByProperty("cname", true);
			itDTOs.forEach(System.out::println);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		System.out.println("..............................................");
		try {
			itDTOs1=service.fetchAllCustomersSortByProperties(true,"cname","cadd","billAmt");
			itDTOs1.forEach(System.out::println);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		System.out.println("..............................................");
		try {
			itDTOs3=service.fetchCustomerRecordsByPageNoAndSize(1, 2);
			itDTOs3.forEach(System.out::println);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main(-)

}//class
