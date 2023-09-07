package com.app;
/**
 * Interface for the controller the logic might changes in diffrent implementation  
 * but this provide a unify way to implement the two systems.
 * @author Tuan Nguyen 
 *
 */
import java.io.File;

import com.app.exceptions.InvalidDataFormat;
import com.app.exceptions.PatientNotFound;  
 interface Controller {
	 /**
	  * Remove the patient with such id 
	  * @param id
	  */
	    void remove(int id) ;
	    /**
	     * Remove the patient with that such name  
	     * @param name
	     */
	    void remove(String name) ;
	    /**
	     * Add a patient to the system  
	     * @param p
	     * @return  The patient ID (key) 
	     */
	    int add(Patient p) ;

	    /**
	     * Add the patient data to the system.
	     * The string arrays is a an array tokenized from the readline data 
	     * @param data
	     * @return  The patient ID (key) 
	     * @throws InvalidDataFormat 
	     */
		int add(String[] data) throws InvalidDataFormat; 

	    /** 
	     * Edit the info of the patient  
	     * @param id of the patient  
	     */
	    void edit(int id ) throws PatientNotFound;
	    /**
	     * Edit the info of the patient with this name 
	     * @param name
	     */
	    void edit(String name) throws PatientNotFound ;
	    /**
	     * Export file  
	     * @param path
	     */
	    void export(String path) ;
	    /**
	     *  Get the patient with the input id 
	     *   
	     * @param id
	     * @return return null  if patient not found . 
	     */
	    Patient get (int id) throws PatientNotFound;
	    /**
	     * 
	     * @param name
	     * @return
	     */
	    Patient get (String name) throws PatientNotFound;

	    /**
	     * Print the summary details for the current system.
	     * Summary details will include: Total patient,Total high risk patient,Most busiest time . 
	     */
	    void summary() ;
	    /**
	     * 
	     * @return the current number of patient in the system
	     */
	    int count();
	    /** 
	     * 
	     * @param name
	     * @return
	     */
	    boolean search(String name) ;
	    /** 
	     * 
	     * @param id
	     * @return
	     */
	    boolean search(int id) ;
}
