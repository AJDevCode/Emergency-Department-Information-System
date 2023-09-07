package com.app  ;
import java.util.Date;
import java.util.Objects;
/**
 * The patient data store by the controller 
 * @author Tuan Nguyen 
 *
 */
class Data{ 
	String arriveTimeOfDay;
}
/* The patient class only contains the id and have a data object  
 */
public class  Patient{
	private int id ; 
   private String name ; 
   private int age ; 
   private Date intakeTime; 

   /**
 * @return the intakeTime
 */
public Date getIntakeTime() {
	return intakeTime;
}
/**
 * @param intakeTime the intakeTime to set
 */
public void setIntakeTime(Date intakeTime) {
	this.intakeTime = intakeTime;
}
public Patient (String name , int age , Date intakeTime){
	this.setName(name); 
	this.setAge(age); 
	if(intakeTime!=null) {
		this.setIntakeTime(intakeTime);
	}
	this.setId(this.hashCode());
}
    /* Setter and getter object for the class. 
     *      
     * */
	public int getId(){ 
		return this.id ; 
	}
	private void setId(int hash) {
		this.id = hash; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, intakeTime, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Patient)) {
			return false;
		}
		Patient other = (Patient) obj;
		return age == other.age && Objects.equals(intakeTime, other.intakeTime) && Objects.equals(name, other.name);
	}
}

