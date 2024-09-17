package com.example.br.etechoracio.pw3_study.Service;

import com.example.br.etechoracio.pw3_study.Entity.Monitor;
import com.example.br.etechoracio.pw3_study.Repository.MonitorRepository;
import com.example.br.etechoracio.pw3_study.dto.MonitorResponseDTO;
import com.example.br.etechoracio.pw3_study.dto.MonitorUpdateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MonitorService {
    @Autowired
    private MonitorRepository monitorRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Transactional
    public List<MonitorResponseDTO> getAllMonitor(){
        var lista = monitorRepository.findAll();
        var result = lista.stream().map(e -> modelMapper.map(e, MonitorResponseDTO.class)).collect(Collectors.toList());
        return result;
    }
    @Transactional
    public MonitorResponseDTO getMonitorById(Long id){
        var busca = monitorRepository.findById(id).map(e -> modelMapper.map(e, MonitorResponseDTO.class)).orElseThrow(()-> new NoSuchElementException("Esse monitor não existe"));
        return busca;
    }
    @Transactional
    public MonitorResponseDTO save(MonitorResponseDTO monitorResponseDTO){
        Monitor monitor = modelMapper.map(monitorResponseDTO, Monitor.class);
        return modelMapper.map(monitorRepository.save(monitor), MonitorResponseDTO.class);
    }
    @Transactional
    public void delete(Long id){
        monitorRepository.deleteById(id);
    }
    @Transactional
    public MonitorResponseDTO update(MonitorUpdateDTO monitorUpdateDTO, Long id) {
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Monitor não encontrado"));
        modelMapper.map(monitorUpdateDTO, monitor);

        return modelMapper.map(monitorRepository.save(monitor), MonitorResponseDTO.class);
    }
}