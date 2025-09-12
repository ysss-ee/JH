package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteReportRequest {
    @JsonProperty("reportId")
    @NotNull
    private Integer reportId;
    @JsonProperty("userId")
    @NotNull
    private Integer userId;
    @NotNull
    private Integer approval;
}
