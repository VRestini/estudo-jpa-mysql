package com.example.br.etechoracio.pw3_study.dto;

import com.example.br.etechoracio.pw3_study.Entity.Disciplina;
import lombok.Data;

@Data
public class MonitorResponseDTO {
    private String nome;
    private String foto;
    private String whatsapp;
    private String email;
    private String conteudo;
    private Long disciplina;
}
