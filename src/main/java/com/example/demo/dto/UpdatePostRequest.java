package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UpdatePostRequest {
    @JsonProperty("userId")
    @NotNull
    private Integer userId;
    @JsonProperty("postId")
    @NotNull
    private Integer postId;
    @NotNull
    private String content;
}
