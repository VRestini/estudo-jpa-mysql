package com.example.br.etechoracio.pw3_study.Controller;

import com.example.br.etechoracio.pw3_study.Service.MonitorService;
import com.example.br.etechoracio.pw3_study.dto.MonitorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    public MonitorService service;
    @GetMapping
    public ResponseEntity<List<MonitorResponseDTO>> getAllMonitors(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMonitor());
    }
    @PostMapping("/save")
    public ResponseEntity<MonitorResponseDTO> saveMonitor(@RequestBody MonitorResponseDTO monitorResponseDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(monitorResponseDTO));
    }
}
