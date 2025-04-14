package com.ipn.mx.dominio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ipn.mx.dominio.entidades.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    @Query("SELECT e FROM Evento e WHERE e.nombreEvento LIKE %:nombree%")
    public List<Evento> findByNombre(String nombre);
    
}
