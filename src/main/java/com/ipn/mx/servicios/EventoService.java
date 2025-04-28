package com.ipn.mx.servicios;

import java.util.List;
import com.ipn.mx.dominio.entidades.Evento;
import com.ipn.mx.dominio.repositorios.EventoRepository;
public interface EventoService {
    public List<Evento> readAll();
    public Evento read(Long id);
    public List<Evento> readByNombre(String nombre);
}
