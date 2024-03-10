package com.tka.DbAddress.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DbAddress.dao.AddressDao;
import com.tka.DbAddress.entity.Address;

@Service
public class AddressService {
    
	@Autowired
	AddressDao dao;
	
	public String insertdata(Address add) {
		String msg = dao.insertdata(add);
		return msg;
	}
	
	public String updatedata(Address add,int pincode) {
		String msg=dao.updatedata(add, pincode);
		return msg;
	}
	
	public String deletedata(int pincode) {
	      String msg= dao.deletedata(pincode);
	      return msg;
		
	}
	
	public Address getparticulardata(int pincode) {
	     Address a = dao.getparticulardata(pincode);
	     return a;
		
	}
	
	public java.util.List<Address> getAlldata() {
	  java.util.List<Address> list=dao.getAlldata();
	  return list;
	}
}
	

