package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportPostsRequest {
    @JsonProperty("postId")
    @NotNull
    private Integer postId;
    @NotNull
    private Integer userId;
    @NotNull
    private String reason;
}
