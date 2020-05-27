package com.metodologia.flyseven.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by efalcon
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Viaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViaje;

    private LocalDateTime ida;

    private LocalDateTime vuelta;

    private String nombre;

    private String destino;

    private String descripcion;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("usuarioId")
    private Usuario usuario;

    @ManyToMany
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVuelo")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("vuelosIds")
    private List<Vuelo> vuelos;

    @JsonIgnore
    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    @JsonProperty("vuelosIds")
    public void setVuelosIds(List<Integer> vuelosIds) {
        this.vuelos = vuelosIds.stream()
                .map(Vuelo::fromId)
                .collect(Collectors.toList());
    }

    @JsonProperty("usuarioId")
    public void setUsuarioId(Integer usuarioId) {
        this.usuario = Usuario.fromId(usuarioId);
    }

    @JsonIgnore
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
