package Pegas.service;

import Pegas.dto.TaskCreateUpdateDto;
import Pegas.dto.TaskReadDto;
import Pegas.entity.Status;
import Pegas.mapper.TaskCreateUpdateMapper;
import Pegas.mapper.TaskReadMapper;
import Pegas.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {
    private final TaskCreateUpdateMapper taskCreateUpdateMapper;
    private final TaskReadMapper taskReadMapper;
    private final TaskRepository taskRepository;

    public List<TaskReadDto> findAll(){
        return taskRepository.findAll().stream().map(taskReadMapper::fromTo).toList();
    }

    public List<TaskReadDto> findAllByStatus(Status status){
        return taskRepository.findByStatus(status).stream().map(taskReadMapper::fromTo).toList();
    }

    public Optional<TaskReadDto> findById(Long id){
        return taskRepository.findById(id).map(taskReadMapper::fromTo);
    }

    @Transactional
    public TaskReadDto create(TaskCreateUpdateDto taskCreateUpdateDto){
        return Optional.of(taskCreateUpdateDto).map(taskCreateUpdateMapper::fromTo)
                .map(taskRepository::save)
                .map(taskReadMapper::fromTo)
                .orElseThrow();
    }
    @Transactional
    public boolean delete(Long id){
        return taskRepository.findById(id).map(i->{
            taskRepository.delete(i);
            taskRepository.flush();
            return true;
        }).orElse(false);
    }
    @Transactional
    public TaskReadDto update(Long id, TaskCreateUpdateDto taskCreateUpdateDto){
        return taskRepository.findById(id).map(i->taskCreateUpdateMapper.fromTo(taskCreateUpdateDto, i))
                .map(taskRepository::save)
                .map(taskReadMapper::fromTo)
                .orElseThrow();
    }
}
