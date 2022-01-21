package com.example.hospital.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hospital.model.Patient;

public interface PatientRepository extends CrudRepository<Patient,String> {

}