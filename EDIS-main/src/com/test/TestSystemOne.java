package com.test;
import com.app.* ;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSystemOne {
	//Test add function
	@Test
	void addPatient() {
		SystemOne  sys = new SystemOne() ;
		Patient p = new Patient("Jonh Smith",42,new Date()); 
		Patient c = new Patient("Nigga Smith",42,new Date()); 
		Patient d = new Patient("Shit Smith",42,new Date()); 
		sys.add(p);
		sys.add(c);
		sys.add(d);
		assertEquals(3,sys.count()) ;

	}
	//Test get patient 
	@Test
	void testGet() { 
		//Throws a PatientNotFound error
		SystemOne  sys = new SystemOne() ;
		Patient p = new Patient("Jonh Smith",42,new Date()); 
		int id = p.hashCode() ;
		sys.add(p);
		sys.get(id) ;
		assertEquals(1,sys.count()) ;
	}
	@Test
	void testGet2() { 
		//Find a not found patient expect to throws a Patient Not found  
	}

	//Test remove function
	@Test
	void testRemove() { 
		//Throws a PatientNotFound error
	}
	//Test edit function  
	@Test 
	void testEdit() { 
		
	}
	@Test 
	void testEditWithName() { 
		
	}
	@Test 
	void testEditWithId() { 
		
	}

	
	// Test process Patient string  
	@Test
	void processPatientStringData() { 
		SystemOne  sys = new SystemOne() ;
		String[]  t = {"James/Smith","42","03-04-2021"} ;
		int id =sys.add(t) ;
		Patient p = sys.get(id) ;
		assertEquals(1,sys.count()) ;
		assertEquals(42,p.getAge()) ;
		assertEquals("James/Smith",p.getName()) ;
	}
	@Test
	void getName() { 
	}
	@Test 
	void getId() { 
	}
}
