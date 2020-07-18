package com.tapriBrewCafe.dashboard.staffMgmt.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Slf4j
public class Utils {

    public static String toJson(Object body) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(NON_NULL);
            return mapper.writeValueAsString(body);
        } catch (Exception e) {
            log.error("Failed to write to JSON string: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
