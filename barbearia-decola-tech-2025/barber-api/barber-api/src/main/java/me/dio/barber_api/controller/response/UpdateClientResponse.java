package me.dio.barber_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateClientResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("email")
        String email,
        @JsonProperty("phone")
        String phone
) {}