package com.tka.DbAddress.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DbAddress.entity.Address;

@Repository
public class AddressDao {
	
    @Autowired
	SessionFactory factory;
    
    public String insertdata(Address add) {
    	Session session =factory.openSession();
    	session.beginTransaction();
    	session.persist(add);
    	session.getTransaction().commit();
    	session.close();
    	return"data is inserted...";
    	
    }
    
    public String updatedata(Address add,int pincode) {
    	Session session =factory.openSession();
    	session.beginTransaction();
    	
       Address aaa = session.get(Address.class,pincode);
        aaa.setCountry(add.getCountry());
        aaa.setState(add.getState());
        aaa.setCity(add.getCity());
        
        session.merge(aaa);
        session.getTransaction().commit();
        session.close();
    	
    	return "data is updated...";
    }
    
    public String deletedata(int pincode) {
    	Session session = factory.openSession();
    	session.beginTransaction();
    	
    	Address add = session.get(Address.class,pincode);
    	session.remove(add);
    	session.getTransaction().commit();
    	session.close();
    	return "data is deleted...";
    	
    }
    
    public Address getparticulardata(int pincode) {
    	Session session = factory.openSession();
    	session.beginTransaction();
    	
     String hqlQuery = "from Address where pincode=:myid";
      
     Query<Address> query = session.createQuery(hqlQuery,Address.class);
     query.setParameter("myid",pincode);
     
     Address a= query.uniqueResult();
     session.getTransaction().commit();
     session.close();
     return a;
	
    }
    public List<Address> getAlldata() {
    	Session session = factory.openSession();
    	session.beginTransaction();

    	String hqlQuery="from Address";
       Query<Address> query = session.createQuery(hqlQuery,Address.class);
      List<Address> list= query.list();
      
    	session.getTransaction().commit();
    	session.close();
    	return list;
    }
}
