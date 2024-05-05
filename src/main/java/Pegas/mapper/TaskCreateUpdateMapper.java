package Pegas.mapper;

import Pegas.dto.TaskCreateUpdateDto;
import Pegas.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskCreateUpdateMapper implements Mapper<TaskCreateUpdateDto, Task>{
    @Override
    public Task fromTo(TaskCreateUpdateDto taskCreateUpdateDto) {
        Task task = new Task();
        task.setDescription(taskCreateUpdateDto.getDescription());
        task.setStatus(taskCreateUpdateDto.getStatus());
        task.setCreatedDate(taskCreateUpdateDto.getCreatedDate()==null ? LocalDateTime.now(): taskCreateUpdateDto.getCreatedDate());
        return task;
    }

    @Override
    public Task fromTo(TaskCreateUpdateDto taskCreateUpdateDto, Task task) {
        task.setDescription(taskCreateUpdateDto.getDescription().isBlank()?task.getDescription(): taskCreateUpdateDto.getDescription());
        task.setStatus(taskCreateUpdateDto.getStatus());
        task.setCreatedDate(LocalDateTime.now());
        return task;
    }
}
