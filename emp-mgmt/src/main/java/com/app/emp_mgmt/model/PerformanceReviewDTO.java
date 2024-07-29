package com.app.emp_mgmt.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceReviewDTO {

    private Long perRevId;
    private Long empId;
    private LocalDate reviewDate;
    private String comments;
    private Integer rating;
}