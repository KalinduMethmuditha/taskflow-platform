package com.kalindu.taskflow.dto;

import com.kalindu.taskflow.enums.TaskStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskStatusUpdateDTO {

    private TaskStatus status;
}