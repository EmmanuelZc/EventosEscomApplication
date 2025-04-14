package com.ipn.mx.infraestructura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.ipn.mx.servicios.EventoService; 
import com.ipn.mx.dominio.entidades.Evento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;   
import org.springframework.web.bind.annotation.RequestParam;
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

        @GetMapping("/eventos/ {id}")
        public ResponseEntity<?> read(@PathVariable Long id) {
            Evento e = null;
            Map<String, Object> response = new HashMap<>();
            try {
                e = eventoService.read(id);
            } catch (DataAccessException e) {
                response.put("mensaje", "Error al consultar el evento");
                response.put("error", e.getMessage()
                .concat(": ")
                .concat(e.getMostSpecificCause().getMessage())
                );
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

            }
            
        }


}
