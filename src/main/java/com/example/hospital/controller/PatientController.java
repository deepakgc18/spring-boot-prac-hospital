package com.example.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/patients/all")
    public List<Patient> allPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> patientByID(@PathVariable String id) {
        return patientService.getPatientByID(id);
    }

    @PostMapping("/add")
    public boolean addPatient(@RequestBody Patient patient) {

        return patientService.insertPatient(patient);
    }
}
