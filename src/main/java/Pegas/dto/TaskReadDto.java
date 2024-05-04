package Pegas.dto;

import Pegas.entity.Status;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskReadDto {
    Long id;
    String description;
    Status status;
    LocalDateTime createdDate;
}
