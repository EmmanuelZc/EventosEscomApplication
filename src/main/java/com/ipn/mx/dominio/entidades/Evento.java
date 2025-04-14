package com.ipn.mx.dominio.entidades;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Evento")
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idEvento;

    @NotBlank(message = "El nombre del evento no puede estar vacío")
    @Column(name = "nombreEvento", nullable = false, length = 100)
    private String nombreEvento;

    @Temporal(jakarta.persistence.TemporalType.DATE)
    @Column(name = "fechaEvento", nullable = false)
    private Date fechaEvento;

    @Column(name = "duracionEvento", nullable = false)
    private int duracionEvento;

    

}
