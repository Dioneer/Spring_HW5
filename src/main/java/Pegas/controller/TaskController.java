package Pegas.controller;

import Pegas.dto.TaskCreateUpdateDto;
import Pegas.dto.TaskReadDto;
import Pegas.entity.Status;
import Pegas.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskReadDto addTask(@RequestBody TaskCreateUpdateDto createUpdateDto){
        return taskService.create(createUpdateDto);
    }
    @GetMapping
    public List<TaskReadDto> findAllTasks(){
        return taskService.findAll();
    }
    @GetMapping("/status/{status}")
    public List<TaskReadDto> getTasksByStatus(@PathVariable Status status){
        return taskService.findAllByStatus(status);
    }
    @PutMapping("/{id}")
    public TaskReadDto update(@PathVariable Long id, @RequestBody TaskCreateUpdateDto createUpdateDto){
        return taskService.update(id, createUpdateDto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return taskService.delete(id);
    }
}
