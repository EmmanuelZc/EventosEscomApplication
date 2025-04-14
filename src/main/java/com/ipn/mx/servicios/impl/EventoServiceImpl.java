package com.ipn.mx.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.ipn.mx.dominio.entidades.Evento;
import com.ipn.mx.dominio.repositorios.EventoRepository;
import com.ipn.mx.servicios.EventoService;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Override
    public List<Evento> readAll() {
        return eventoRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Evento read(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }
    @Override
    public List<Evento> readByNombre(String nombre) {
        return eventoRepository.findByNombre(nombre); // Implementación del método
    }
}
