package com.app;
import java.util.* ;

import com.app.exceptions.InvalidDataFormat;
import com.app.exceptions.InvalidTokensNum;

import java.io.File;
import java.io.FileNotFoundException;
public class App {
	/**
	 *  The controller could be defined in term of two classes  
	 */
	Scanner sc ; 
	Controller controller;
	/** 
	 * Print the first n number of patient  
	 * @param num
	 */
	private void printData(int num) { 
		
	}
	/**
	 * Help Text for the program 
	 */
	private void printHelp() { 
		//Print help text 
		System.out.println("Use our interactive shell software with simple syntax\n"
				+ "\t 1.load <input_file>\n"
				+ "\t 2.export <export_file>\n"
				+ "\t 3. get [name][id] \n"
				+ "\t 4. add <name><age><dd-MM-yyyy><data>\n"
				+ "\t 5. remove <PatientList> \n"
				+ "\t 6. search [--id][--name][--age] \n" 
				+ "\t 7. quit \n") ;
		System.out.println("You can also query the data and filter by risk ,"
				+ "blood pressure by using --filter class ") ;
	}

	/* Print Banner for the software 
	 * */
	private void printBanner() { 
		String ANSI_YELLOW = "\u001B[33m";
		String ANSI_RESET = "\u001B[0m";
		String banner = "####### ######  ###  #####  \n"
				+ "#       #     #  #  #     # \n"
				+ "#       #     #  #  #       \n"
				+ "#####   #     #  #   #####  \n"
				+ "#       #     #  #        # \n"
				+ "#       #     #  #  #     # \n"
				+ "####### ######  ###  #####  " ;
		 System.out.println(ANSI_YELLOW
                 +banner + ANSI_RESET);
		 System.out.print("\n")  ;

	}
	/**
	 * Load a file that contains the current system patient data 
	 * .To be a valid file,each line must follow the syntax: 
	 * <name> <age> <arriveTime> <Data>  
	 * Upon successful creation of the input patient info , the controller will output the input file summary table  
	 * @param file
	 * @return  
	 */
	private void loadFile(String path) { 
		//Parse the input file and store data to the controller 
		// Open the file Scan for each line of the file to 
		// Print input summary details ( Total new patient, Currently vacant doctor)  
		File load = new File(path) ;
		Scanner sc ;
		try {
			sc = new Scanner(load);
			while(sc.hasNextLine()) { 
				String data = sc.nextLine(); 
				//Tokenize the input
				StringTokenizer tc = new StringTokenizer(data," ") ;
				int size  = tc.countTokens();
				String [] patientArray= new String[size] ;
				int i =0;
				while(tc.hasMoreTokens()) {
					patientArray[i]= tc.nextToken().trim() ;
					i++ ;
				}
				int newPatientId;
				try {
					newPatientId = controller.add(patientArray);
					System.out.printf(" New Patient Id added %sw\n",Integer.toHexString(newPatientId) ); 
				} catch (InvalidDataFormat e) {
					// TODO Auto-generated catch block
					System.out.print(e.getMessage()) ;
				}
				//Summary of input patient 
			}
			 
		} catch (FileNotFoundException e) {
			System.out.println("File name not found !") ;
		}
	}
	/**
	 * Helper method to export data to file.  
	 */
	private void saveData() {

		//The default name for the export 
		//String  defaultName ="Patient_data.txt" ;
		String path = "." ;
	}
	public void quit() { 
		System.out.println("Do you want to exit the program,all patient data will be lost\n"
				+ "Do you want to safe current data ? (Y/n)") ;
		String op= sc.next(); 
		boolean save =  op.equals("y")||op.equals("Y");
		//Check what choice the user have 
		if(save) { 
			//writeData() ;
			saveData() ;
		}
		System.out.println("Quit Success !")  ;
		System.exit(0);
		
	}
	/**
	 * Check for userinput and create new paitent  
	 *  @return theNewly create patientID
	 */
	public int takePatientInput(int numTokens, String[] data ) throws InvalidTokensNum{
		//TODO: Handle incorrect input data 
		
		final int STRING_DATA_SIZE = 3 ;
		if(numTokens-1!=STRING_DATA_SIZE) {
			throw new InvalidTokensNum("To add new patient follow the syntax : add <name> <age> <arriveTime>") ;
		}
		int id=0;
		try { 
			//TODO : Modify the controller to throws InvalidDataFormat when invalid input
			id =controller.add(data) ;
			System.out.printf(" New Patient Id added %sw\n",Integer.toHexString(id)); 
		} catch (Exception e) {
			
		}
		return id;
	}
	/**
	 * Execute the option choosen by user , in each options you should have a  data check   
	 * There are multiple operation: 
	 *  <ul>
	 * 		<li> quit</li> 
	 * 		<li> load <file_path> </li> 
	 * 		<li> add <Patient>  </li> 
	 * 		<li> remove <Patient> or {PatientList}  </li> 
	 * 		<li> export <output_file_path> </li> 
	 * 		<li> list <int>  </li> 
	 *  </ul> 
	 * @param option
	 * @return 
	 */
    public void execute(String option){

    	//Tokenize input 
    	StringTokenizer st = new StringTokenizer(option) ;
    	// Number of user input each loop iteration 
    	final int numTokens=st.countTokens() ;
    	//Check if the number of tokens is also valid for each type of operation
    	String[] flag  = new String[numTokens] ; 
    	for(int i=0;i<numTokens;i++) { 
    		flag[i] = st.nextToken() ;
    	}
    	String mode  = flag[0] ;
    	switch(mode) { 
    		/**
    		 * User to quit the app,a save prompt will appear for user to select to save the current user data to the system. 
    		 */
				case( "quit"): {
					if(numTokens==1) quit() ;
					//else throws Exception.Wrong numbers of arguments 
				}
				case("load"):{ 
					//TODO : Make sure the path is correct and was able to open 
					try { 
						loadFile(flag[1]);
					}catch(Exception err ) { 
						System.out.println(err.getMessage()) ;
					}
					
				}
				case("export"):{ 
					//Export parse the  
				}
				case("add"):{
					//We need <name><age><arriveTime>
					try {
						takePatientInput(numTokens,Arrays.copyOfRange(flag,1,flag.length)) ;
					}
					catch(Exception err) {
						System.out.println(err.getMessage()) ;
					}
				} 
				case("remove"):{ 
					
				}
				case("list"):{ 
					//Show the first n number of patient in the db  
					//allow search and filter the function too , or store the key value of that patient objet in an array 
				}
    	} 
    }
    public App(){ 
    	sc = new Scanner(System.in) ;
    	controller = new SystemOne() ;
    	printBanner() ;
    	printHelp() ;
    }

    /*
     *  Main loop for the software 
     */
    private void loop(){ 
        String prompt= "EDIS > " ;
        String option ;
        while(true){ 
            System.out.print(prompt) ;
            option = sc.nextLine() ; 
            //Check if the option is empty  
            if(option=="") {
            	continue;
            }
            execute(option) ;
        }
    }
    public static void main(String[] args){
        App n = new App()  ;
        n.loop() ;
    }

}
