package com.example.br.etechoracio.pw3_study.dto;

import lombok.Data;

@Data
public class MonitorResponseDTO {
    private String nome;
    private String foto;
    private Long whatsapp;
    private String email;
    private String conteudo;
    private DisciplinaMonitorDTO disciplina;
}
