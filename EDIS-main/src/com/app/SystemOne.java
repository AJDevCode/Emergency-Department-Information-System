package com.app;
import java.io.File ;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat ;
import java.util.concurrent.ConcurrentNavigableMap ;
import java.util.concurrent.ConcurrentSkipListMap;
import com.app.Patient;
import com.app.exceptions.InvalidDataFormat;
import com.app.exceptions.PatientNotFound;

public class SystemOne implements Controller {
	ConcurrentNavigableMap<Integer,Patient>  map;
	public SystemOne(){
		map= new ConcurrentSkipListMap() ;
	}
	/**
	 *  A remove operation of a skip list sorted Map  
	 *  Analysis  : Textbook
	 */
	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String name) {
		// TODO Auto-generated method stub

	}

	/** 
	 * Put the patient in the system  
	 * Analysis: from the textbook 
	 */
	@Override
	public int add(Patient p) {
		// TODO Auto-generated method stub
		int hash = p.getId();
		map.putIfAbsent(hash, p) ;
		return hash  ;
	}

	@Override
	public int add(String[] data) throws InvalidDataFormat {
		/**
		 * Input :  A tokenized patient String data and construct new patient . 
		 * <name><age><arriveTime><Data>
		 * Output:  The ID of the patient   
		 */
		Patient p  ;
		String pName = data[0] ;
		int  pAge = Integer.parseInt(data[1]) ;
		//Parse the date from string 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date pArriveTime  =null;
		try {
			pArriveTime = formatter.parse(data[2]) ;
		} catch (ParseException e) {
			//Print out errormessage  
			throw new InvalidDataFormat("Invalid input data, date must be in the format dd-MM-yyyy") ;
		} 
		p = new Patient(pName,pAge,pArriveTime)  ;
		return this.add(p) ;
	}

	@Override
	public void edit(int id) throws PatientNotFound{
		// TODO Auto-generated method stub
		Patient p = map.get(id) ;
		
	}

	@Override
	public void edit(String name) throws PatientNotFound {
		// TODO Auto-generated method stub

	}


	@Override
	public void export(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void summary() {
		// TODO Auto-generated method stub

	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return map.size();
	}
	@Override
	public boolean search(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean search(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @param id 
	 * @throws PatientNotFound
	 * @return the Patient Object if the key is found
	 * A get operation  on the skipList implementation of sorted set  
	 * Analysys: Textbook
	 */
	@Override
	public Patient get(int id) throws PatientNotFound {
		// TODO Auto-generated method stub
		if(map.containsKey(id)) {
			return map.get(id) ;
		}else {
			throw new PatientNotFound("The paitient record is not in the system.") ;
		}
	}

	@Override
	public Patient get(String name) throws PatientNotFound { 
		// TODO Auto-generated method stub
		return null;
	}

}
