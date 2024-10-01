package com.example.br.etechoracio.pw3_study.Service;
import com.example.br.etechoracio.pw3_study.Repository.ConexaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConexaoService {
    @Autowired
    private ConexaoRepository repository;
    private ModelMapper mapper = new ModelMapper();
    public long getAllConexao(){
        long conexoes = repository.count(   );
        return conexoes;
    }
}
