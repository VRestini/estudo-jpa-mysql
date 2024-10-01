package com.example.br.etechoracio.pw3_study.Controller;

import com.example.br.etechoracio.pw3_study.Service.ConexaoService;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conexao")
@CrossOrigin(origins = "*")
public class ConexaoController {
    @Autowired
    private ConexaoService service;
    @GetMapping
    public ResponseEntity<Long> getAllConexoes(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getAllConexao());
    }
}
