package com.metodologia.flyseven.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by efalcon
 */
@Entity
@Data
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVuelo;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("usuarioId")
    private Usuario usuario;

    private String aerolinea;

    private String aeronave;

    private String asiento;

    private String clase;

    private Integer codReserva;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAeropuerto")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("aeropuertoOrigenId")
    private Aeropuerto origen;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAeropuerto")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("aeropuertoDestinoId")
    private Aeropuerto destino;

    private Time duracion;

    private Float distancia;

    private Integer puerta;

    private LocalDateTime inicio;

    private LocalDateTime fin;

    @OneToMany
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVuelo")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Vuelo> escala;

    @JsonProperty("usuarioId")
    public void setProjectById(Integer usuarioId) {
        this.usuario = Usuario.fromId(usuarioId);
    }

    @JsonIgnore
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonProperty("aeropuertoOrigenId")
    public void setAeropuertoOrigen(Integer aeropuertoId) {
        this.origen = Aeropuerto.fromId(aeropuertoId);
    }

    @JsonIgnore
    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    @JsonProperty("aeropuertoDestinoId")
    public void setAeropuertoDestino(Integer aeropuertoId) {
        this.destino = Aeropuerto.fromId(aeropuertoId);
    }

    @JsonIgnore
    public void setDestino(Aeropuerto destino) {
        this.destino = origen;
    }
}
