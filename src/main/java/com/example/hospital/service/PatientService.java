package com.example.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.hospital.repository.PatientRepository;
import com.example.hospital.model.Patient;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public ResponseEntity<String> deletePatientByID(String id){
        if(patientRepository.findById(id).isPresent()){
            patientRepository.deleteById((id));
            return new ResponseEntity<String>("SuccessFully Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
        }
    }

    public List<Patient> findPatientByName(String name){
        List<Patient> patients = new ArrayList<>();
        patientRepository.findByName(name).forEach(patients::add);
        return patients;
    }

    public ResponseEntity<String> updatePatient(Patient patient){
        if(patientRepository.findById(patient.getId()).isPresent()){
            patientRepository.save(patient);
            return new ResponseEntity<String>("SuccessFully Updated",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
        }
    }


}
