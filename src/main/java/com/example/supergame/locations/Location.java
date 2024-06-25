package com.example.supergame.locations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
    private String name;
    private String description;
    private Location[] sublocations;
}
