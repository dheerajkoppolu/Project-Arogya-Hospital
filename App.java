package com.bitlabs.Arogya_Hopsital_Information_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Scanner sc=new Scanner(System.in);
        DAOInterface dao=new DAOImpl();
        Patient p=new Patient();
        medicines m=new medicines();
       
		int option = -1;
		while(option !=0)
        {
		System.out.println();
		System.out.println("Hi ! Please choose the option");
        System.out.println("Press 1 for New Patient Registration ");
        System.out.println("Press 2 for Adding Medicine Record ");
        System.out.println("Press 3 to view All registered patient's details ");
        System.out.println("Press 4 to Delete Patient ID ");
        System.out.println("Press 5 to Update Patient details ");
        System.out.println("Press 6 to view patient details ");
        option=sc.nextInt();
        switch(option)
        {
        
        case 1:
        System.out.println("Enter Id:");
        p.setPatient_id(sc.nextInt());
        System.out.println("Enter Patient name:");
        p.setPatient_name(sc.next());
        System.out.println("Enter Age:");
        p.setAge(sc.nextInt());
        System.out.println("Enter mobile number:");
        p.setMobile(sc.nextLong());
        System.out.println("Enter city:");
        p.setCity(sc.next());
        
        dao.patientRegistration(p);
        break;
        
        case 2:
        System.out.println("Enter medicine id: ");
        m.setMedicine_id(sc.nextInt());
        System.out.println("Enter medicine name");
        m.setMedicine_name(sc.next());
        System.out.println("Enter price of the medicine");
        m.setPrice(sc.nextInt());
        
        dao.addingMedicalRecords(m);   
        break;
        
        case 3:
        dao.viewAllPatients(p);
        break;
        
        case 4:
	    System.out.println("Enter the ID to delete: ");
	    p.setPatient_id(sc.nextInt());
	    dao.deletePatientById(p.patient_id);
	    break;
	    
        case 5:
        	
        System.out.println("Enter Id:");
        p.setPatient_id(sc.nextInt());
        System.out.println("Enter Patient Name:");
        p.setPatient_name(sc.next());
        System.out.println("Enter age:");
        p.setAge(sc.nextInt());
        System.out.println("Enter Mobile number:");
        p.setMobile(sc.nextLong());
        System.out.println("Enter city:");
        p.setCity(sc.next());
        dao.updatePatientInfo(p);
        break;
	    
        case 6:
        	
        	System.out.println("Enter the ID to delete: ");
    	    p.setPatient_id(sc.nextInt());
        	dao.getPatientById(p.patient_id);
        	break;
        }
        }
         
        
               
    
    	
    }	
    }
