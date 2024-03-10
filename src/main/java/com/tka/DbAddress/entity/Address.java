package com.tka.DbAddress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
    
	@Id
	int pincode;
	String country;
	String state;
	String city;
	
	
	public Address() {
		
	}
	
	public Address(int pincode, String country, String state, String city) {
		super();
		this.pincode = pincode;
		this.country = country;
		this.state = state;
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}
	
}
