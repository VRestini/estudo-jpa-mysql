package com.example.br.etechoracio.pw3_study.Service;

import com.example.br.etechoracio.pw3_study.Entity.Disciplina;
import com.example.br.etechoracio.pw3_study.Repository.DisciplinaRepository;
import com.example.br.etechoracio.pw3_study.dto.DisciplinaResponseDTO;
import com.example.br.etechoracio.pw3_study.dto.DisciplinaUpdateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;
    private ModelMapper modelMap = new ModelMapper();

    public List<DisciplinaResponseDTO> getAllDisciplina(){
        var disciplinas = repository.findAll();
        var resultado = disciplinas.stream().map(e -> modelMap.map(e, DisciplinaResponseDTO.class))
                .collect(Collectors.toList());
        return resultado;

    }
    @Transactional
    public DisciplinaResponseDTO saveDisciplica(DisciplinaResponseDTO disciplinaResponseDto){
        Disciplina disciplina = modelMap.map(disciplinaResponseDto, Disciplina.class);
        return modelMap.map(repository.save(disciplina), DisciplinaResponseDTO.class);
    }
    @Transactional
    public void deleteDisciplina(Long id){
        repository.deleteById(id);
    }
    @Transactional
    public Optional<Disciplina> getById(Long id){
        return repository.findById(id);
    }
    @Transactional
    public Disciplina updateDisciplina(DisciplinaUpdateDTO disciplinaUpdateDTO, Long id){
        Disciplina disciplina = repository.findById(id).orElseThrow(()-> new NoSuchElementException("Essa disciplina não existe"));

        disciplina.setNome(disciplinaUpdateDTO.getNome());
        return repository.save(disciplina); 
    }

}
