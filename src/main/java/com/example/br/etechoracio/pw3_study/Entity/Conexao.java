package com.example.br.etechoracio.pw3_study.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "TBL_CONEXAO")
public class Conexao {
    @Id
    @Column(name = "ID_CONEXAO")
    private Long id;
    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDateTime dtCriacao;
    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    private Monitor monitor;
}
