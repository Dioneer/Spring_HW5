package Pegas.repository;

import Pegas.dto.TaskFilter;
import Pegas.entity.Task;

import java.util.List;

public interface TaskFilterRepository {
    List<Task> findAllByFilter(TaskFilter taskFilter);
}
