package com.example.br.etechoracio.pw3_study.Controller;


import com.example.br.etechoracio.pw3_study.Service.DisciplinaService;
import com.example.br.etechoracio.pw3_study.dto.DisciplinaResponseDTO;
import com.example.br.etechoracio.pw3_study.dto.DisciplinaUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/disciplina")
@CrossOrigin(origins = "*")
public class DisciplinaController {
    @Autowired
    public DisciplinaService disciplinaService;
    @PostMapping("/save")
    public ResponseEntity<DisciplinaResponseDTO> saveDisciplina(@RequestBody DisciplinaResponseDTO disciplinaResponseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.saveDisciplica(disciplinaResponseDto));
    }
    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> getDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getAllDisciplina());
    }
    @GetMapping("/{id}")
    public ResponseEntity getDisciplinaById(@PathVariable Long id){
        if (disciplinaService.getById(id).isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getById(id));

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDisciplina(@PathVariable Long id){
        disciplinaService.deleteDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada");
    }
    @PutMapping("{id}")
    public ResponseEntity updateDisciplina(@PathVariable Long id, @RequestBody DisciplinaUpdateDTO disciplinaResponseDto){
        return ResponseEntity.ok(disciplinaService.updateDisciplina( disciplinaResponseDto, id));
    }
}
