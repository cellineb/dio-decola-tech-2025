package me.dio.barber_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record SaveScheduleResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("startAt")
        OffsetDateTime startAt,
        @JsonProperty("endAt")
        OffsetDateTime endAt,
        @JsonProperty("clientId")
        Long clientId
) {}
