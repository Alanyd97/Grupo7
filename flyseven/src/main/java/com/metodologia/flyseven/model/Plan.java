package com.metodologia.flyseven.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by efalcon
 */
@Data
@Entity
public abstract class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Integer id;
    protected String name;
    protected LocalDateTime inicio;
    protected LocalDateTime fin;
    public abstract String getType();
}
