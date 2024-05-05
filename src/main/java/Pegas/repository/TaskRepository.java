package Pegas.repository;

import Pegas.entity.Status;
import Pegas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, TaskFilterRepository, QuerydslPredicateExecutor<Task> {
    List<Task> findByStatus(Status status);
}
