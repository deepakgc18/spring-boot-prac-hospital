package com.example.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.hospital.repository.PatientRepository;
import com.example.hospital.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public boolean insertPatient(Patient patient){
        try{
            patientRepository.save(patient);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    public Optional<Patient> getPatientByID(String id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patient;
    }

}
