package com.kd.springApp.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.NonNull;

@Data
public class testDto {

    @NonNull
    private JsonNode jsonNode;

}
