package com.test.util;

import java.util.ArrayList;

public class TestUtil {

	
	 public static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		// First we have to create a Array list object
		 ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		 
		 // Now we have to call the excel sheet file
		   try {
		    reader = new Xls_Reader("C:\\Users\\Shubham\\eclipse-workspace\\KiposQA\\src\\com\\testdata\\TestData.xlsx");
		    
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
		   // Getting rowcount here
		       int rowCount = reader.getRowCount("SignUpData");
		       
		      // here we can add the new column in excel sheet 
		       
		        reader.addColumn("SignUpData", "status");
		       
		        for(int rowNum=2;rowNum<=rowCount;rowNum++)
		        {
		        String name =reader.getCellData("SignUpData", "Name", rowNum);
		           System.out.println(name);
		           
		           String email =reader.getCellData("SignUpData", "Email", rowNum);
		           System.out.println(email);
		             
		           String password =reader.getCellData("SignUpData", "Password", rowNum);
		           System.out.println(password);
		           
		           String confirmpassword =reader.getCellData("SignUpData", "ConfirmPassword", rowNum);
		           System.out.println(confirmpassword);
		           
		           reader.setCellData("SignUpData", "Status", rowNum, "Pass");
		           
		           // Here we are adding the excel data to the object 
		           Object ob[]= {name,email,password,confirmpassword};
		             
		           mydata.add(ob);
		           
		           
		        }
		        // Here we are returning the array list data 
		        return mydata;
	}

}
