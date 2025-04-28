package com.ipn.mx.servicios;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.List;
import com.ipn.mx.dominio.entidades.Evento;
import com.ipn.mx.dominio.repositorios.EventoRepository;

public interface EventoService {
    public List<Evento> readAll();
    public Evento read(Long id);
    public Evento save(Evento evento);
    public void delete(Long id);
    public ByteArrayInputStream getStream();
    public ByteArrayInputStream reportePDF(List<Evento> eventos);
}
