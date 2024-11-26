package com.example.br.etechoracio.pw3_study.Controller;

import com.example.br.etechoracio.pw3_study.Service.MonitorService;
import com.example.br.etechoracio.pw3_study.dto.MonitorResponseDTO;

import com.example.br.etechoracio.pw3_study.dto.MonitorUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor")
@CrossOrigin(origins = "*")
public class MonitorController {
    @Autowired
    public MonitorService service;
    @GetMapping
    public ResponseEntity<List<MonitorResponseDTO>> getAllMonitors(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMonitor());
    }
    @GetMapping("{id}")
    public ResponseEntity<MonitorResponseDTO> getMonitorById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getMonitorById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<MonitorResponseDTO> saveMonitor(@RequestBody MonitorResponseDTO monitorResponseDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(monitorResponseDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMonitor(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Monitor deletado");
    }
    // Fiquei com uma dúvida aqui, lembro que o professor Rogério disse para criar um DTO
    // com o id, para atualizar, ou pelo menos entendi isso
    // para atualizar tem que colocar o id do monitor, tá certo isso?
    @PutMapping("{id}")
    public ResponseEntity<MonitorResponseDTO> updateMonitor(@PathVariable Long id, @RequestBody MonitorUpdateDTO monitorUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(monitorUpdateDTO, id));
    }


}
