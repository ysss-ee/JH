package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LogResponse {
    @JsonProperty("userId")
    @NotNull
    private Integer userId;
    @JsonProperty("userType")
    @NotNull
    private Integer userType;
    @JsonProperty("token")
    @NotNull
    private String token;
}
