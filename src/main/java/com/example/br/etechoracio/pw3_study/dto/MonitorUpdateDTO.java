package com.example.br.etechoracio.pw3_study.dto;

import lombok.Data;

@Data
public class MonitorUpdateDTO {
    private Long id;
    private String nome;
    private String foto;
    private String whatsapp;
    private String email;
    private String conteudo;
    private DisciplinaMonitorDTO disciplina;
}
