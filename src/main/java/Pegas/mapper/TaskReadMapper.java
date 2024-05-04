package Pegas.mapper;

import Pegas.dto.TaskReadDto;
import Pegas.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskReadMapper implements Mapper<Task, TaskReadDto>{
    @Override
    public TaskReadDto fromTo(Task task) {
        return new TaskReadDto(task.getId(), task.getDescription(), task.getStatus(), task.getCreatedDate());
    }
}
