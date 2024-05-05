package Pegas.dto;

import Pegas.entity.Status;

public record TaskFilter(String description, Status status) {

}
