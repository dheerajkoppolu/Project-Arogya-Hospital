package com.bitlabs.Arogya_Hopsital_Information_Management_System;

public interface DAOInterface {
			public void patientRegistration(Patient p);
			public void addingMedicalRecords(medicines m);
			public void viewAllPatients(Patient p);
			public void deletePatientById(int patient_id);
			public void updatePatientInfo(Patient p);
			public void getPatientById(int patient_id);
			
	 
}
