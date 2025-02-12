package com.app.emp_mgmt.model;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
    private Long jobTitleId;
    private Set<Long> projectIds;
    private List<Long> performanceReviewIds;
}
