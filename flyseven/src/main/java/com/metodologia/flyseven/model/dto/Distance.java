package com.metodologia.flyseven.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by efalcon
 */
@Data
@NoArgsConstructor
public class Distance implements Serializable {
    private List<Integer> distances;
    private int distance; // Leave the primitive value, so the default will be 0
}
