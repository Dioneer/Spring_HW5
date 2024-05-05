package Pegas.repository;

import Pegas.dto.Qpredicates;
import Pegas.dto.TaskFilter;
import Pegas.entity.Task;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static Pegas.entity.QTask.task;

@RequiredArgsConstructor
public class TaskFilterRepositoryImpl implements TaskFilterRepository{
    private final EntityManager entityManager;

        @Override
        public List<Task> findAllByFilter(TaskFilter filter) {
            var predicate = Qpredicates.builder()
                .add(filter.description(), task.description::containsIgnoreCase)
                .add(filter.status(), task.status::eq)
                    .build();
            return new JPAQuery<Task>(entityManager)
                .select(task)
                .from(task)
                    .where(predicate)
                    .fetch();
        }
}
