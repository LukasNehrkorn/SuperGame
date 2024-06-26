package com.example.supergame.model.dto;

import com.example.supergame.model.Job;
import com.example.supergame.model.Race;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewPlayerData {
    private String name;
    private Race race;
    private Job job;

    public static NewPlayerData fromJSON(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        return new NewPlayerData(root.at("name").asText(), Race.valueOf(root.at("race").asText()), Job.valueOf(root.at("job").asText()));
    }
}
