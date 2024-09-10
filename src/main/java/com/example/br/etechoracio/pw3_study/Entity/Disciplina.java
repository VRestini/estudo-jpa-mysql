package com.example.br.etechoracio.pw3_study.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISCIPLINA")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Long id;
    @Column(nullable = false, name = "TX_NOME", length = 60)
    private String nome;
    public void setNome(String nome) {
        this.nome = nome;
    }
}
