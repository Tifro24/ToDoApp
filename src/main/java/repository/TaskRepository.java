package repository;

import domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
  void addTask(Task task);
  void deleteTask(UUID id);
  Task getTaskById(UUID id);
  List<Task> getAllTasks();
}
