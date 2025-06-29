package com.kd.springApp.JavaCore;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.Optional;

public class OptionalClass {

    public static void main(String[] arg){

        ObjectMapper objectMapper = new JsonMapper();
        Optional<JsonNode> optional = Optional.ofNullable(objectMapper.createObjectNode());

        System.out.println("opstion "+ optional.isPresent());

    }

}
