package com.example.hospital.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.hospital.model.Patient;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends CrudRepository<Patient,String> {
    public List<Patient> findByName(String name);
}