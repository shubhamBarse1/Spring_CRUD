package com.tka.DbAddress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.DbAddress.entity.Address;
import com.tka.DbAddress.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {
    
	@Autowired
	AddressService service;
	
	@PostMapping("/savedata")
	public String insertdata(@RequestBody Address add) {
		String msg = service.insertdata(add);
		return msg;
	}
	@PutMapping("/updatedata/{pincode}")
	public String updatedata(@PathVariable int pincode ,@RequestBody Address add) {
		String msg = service.updatedata(add, pincode);
		return msg;
	}
	
	@DeleteMapping("/deletedata/{pincode}")
	public String deletedata(@PathVariable int pincode){
		String msg = service.deletedata(pincode);
		return msg;
		}
	
	@GetMapping("/getonedata/{pincode}")
	public Address getparticulardata(@PathVariable int pincode){
		Address a =service.getparticulardata(pincode);
		return a;
		}
	@GetMapping("/getallData")
	public List<Address> getAlldata() {
		List<Address> list =service.getAlldata();
		return list;
	    }
}
