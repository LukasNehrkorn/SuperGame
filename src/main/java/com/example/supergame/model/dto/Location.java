package com.example.supergame.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Location {

    private String name;

    private String description;

    private Location[] subLocations;
}
