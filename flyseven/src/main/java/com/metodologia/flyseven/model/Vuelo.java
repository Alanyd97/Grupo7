package com.metodologia.flyseven.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by efalcon
 */
@Entity
@Data
public class Vuelo extends Plan {

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

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVuelo")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("escalaIds")
    private List<Vuelo> escalas = new ArrayList<>();

    @JsonProperty("usuarioId")
    public void setUsuarioId(Integer usuarioId) {
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
    private void setAeropuertoDestino(Integer aeropuertoId) {
        this.destino = Aeropuerto.fromId(aeropuertoId);
    }

    @JsonIgnore
    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    @JsonProperty("escalas")
    private void setEscalasId(List<Integer> escalasId) {
        this.escalas = escalasId.stream()
                .map(Vuelo::fromId)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public void setEscalas(List<Vuelo> vuelos) {
        this.escalas = vuelos;
    }

    public static Vuelo fromId(Integer id) {
        Vuelo vuelo = new Vuelo();
        vuelo.setId(id);
        return vuelo;
    }

    @Override
    public String getType() {
        return "Vuelo";
    }
}
