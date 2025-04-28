package com.ipn.mx.infraestructura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ipn.mx.servicios.EventoService; 
import com.ipn.mx.dominio.entidades.Evento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    
    @Autowired
    private EventoService eventoService;

    @GetMapping("/eventos")
    @ResponseStatus(HttpStatus.OK)
    public List<Evento> readAll() {
        return eventoService.readAll();
    }

    @GetMapping("/eventos/{id}") // Eliminado el espacio extra
    public ResponseEntity<?> read(@PathVariable Long id) {
        Evento e = null;
        Map<String, Object> response = new HashMap<>();
        try {
            e = eventoService.read(id);
            if (e == null) {
                response.put("mensaje", "El evento con ID: " + id + " no fue encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al consultar el evento");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // Retorno después del catch
        }

        return new ResponseEntity<>(e, HttpStatus.OK); // Se agregó el retorno para la respuesta exitosa
    }
}
