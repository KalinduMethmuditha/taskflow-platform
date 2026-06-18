package com.kalindu.taskflow.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDTO {

    private String name;

    private String description;

    private Long ownerId;
}