package com.bitlabs.Arogya_Hopsital_Information_Management_System;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOImpl implements DAOInterface
{
	Connection con=null;
	public DAOImpl()
	{
		
		//loading the driver
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dheerajk","root","sespl!@3");
			if(con!=null)
				System.out.println("Hello");
			else
				System.out.println("null");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void patientRegistration(Patient p)
	{
		if(con!=null)
		{
			try 
			{
				PreparedStatement st=con.prepareStatement("insert into patient values(?,?,?,?,?)");
				st.setInt(1, p.getPatient_id());
				st.setString(2, p.getPatient_name());
				st.setInt(3, p.getAge());
				st.setLong(4, p.getMobile());
				st.setString(5, p.getCity());
				
				int i=st.executeUpdate();
				if(i!=0)
				{
					System.out.println("Patients details successfully added");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
	}
	
	public void addingMedicalRecords(medicines m)
	
	{
		if(con!=null)
		{
			try {
				PreparedStatement st=con.prepareStatement("insert into medicines values(?,?,?)");
				st.setInt(1, m.getmedicine_id());
				st.setString(2, m.getMedicine_name());
				st.setInt(3, m.getPrice());
				
				int i=st.executeUpdate();
				if(i!=0)
				{
					System.out.println("Medicine records uploaded");
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public void viewAllPatients(Patient p)
	{
		if(con!=null)
		{
			try {
				
				Statement st=con.createStatement();
				ResultSet r=st.executeQuery("select * from Patient");
				while(r.next())
				{
					System.out.println(r.getInt(1)+"   "+r.getString(2)+"   "+r.getInt(3)+"   "+r.getLong(4)+"   "+r.getString(5));
					
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	
		

	public void deletePatientById(int patient_id)
	{
		// TODO Auto-generated method stub
		if(con!=null)
		{
			try
			{
				Statement st=con.createStatement();
				int i=st.executeUpdate("delete from patient where patient_id='"+patient_id+"'");
				  if(i!=0)
				  {
					  System.out.println("patient details deleted scucessfully");
				  }
			}
				  catch(Exception e)
				  {
					  System.out.println(e);
				  }
				
				
			}
		}

	public void updatePatientInfo(Patient p)
	{
		
		try
		{
			Statement st=con.createStatement();
			int i=st.executeUpdate("update Patient set name='"+p.getPatient_name()+"','"+p.getAge()+"','"+p.getMobile()+"','"+p.getCity()+"' where patient_id = '"+p.getPatient_id()+"'");
			if(i!=0)
			{
				System.out.println("Patient details updated successfully");
			}
		}
		catch (Exception e) 
		{
			 System.out.println(e);
		}
		
		
	}

	public void getPatientById(int patient_id)
	{
		// TODO Auto-generated method stub
		try
		{
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from Patient where patient_id = '"+patient_id+"'");
			while(r.next())
			{
				System.out.println(r.getInt(1)+"   "+r.getString(2)+"   "+r.getInt(3)+"   "+r.getLong(4)+"   "+r.getString(5));
				
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	

	
		
	}

	
		
	
	
		
	

	
		
	
	
	
	



