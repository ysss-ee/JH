package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @JsonProperty("userType")
    @NotNull
    private Integer userType;
}
