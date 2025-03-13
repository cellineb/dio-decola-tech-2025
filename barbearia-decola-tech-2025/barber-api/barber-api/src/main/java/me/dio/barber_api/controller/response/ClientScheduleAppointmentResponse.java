package me.dio.barber_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record ClientScheduleAppointmentResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("day")
        Integer day,
        @JsonProperty("startAt")
        OffsetDateTime startAt,
        @JsonProperty("endAt")
        OffsetDateTime endAt,
        @JsonProperty("clientId")
        Long clientId,
        @JsonProperty("clientName")
        String clientName
) {}