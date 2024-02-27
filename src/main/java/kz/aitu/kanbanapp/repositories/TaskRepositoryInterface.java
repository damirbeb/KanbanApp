package kz.aitu.kanbanapp.repositories;

import kz.aitu.kanbanapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepositoryInterface extends JpaRepository<Task, Integer>{
}