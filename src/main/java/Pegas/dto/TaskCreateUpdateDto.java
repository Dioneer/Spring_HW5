package Pegas.dto;

import Pegas.entity.Status;
import lombok.Value;

@Value
public class TaskCreateUpdateDto {
    String description;
    Status status;
}
