package repository;

import domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
  void addTask(Task task);
  void deleteTask(UUID id);
  Task getTaskById(UUID id);
  String getTaskTitleById(UUID id);
  List<Task> getAllTasks();
  void setTaskTitleById(UUID taskId, String title);
  void setTaskComplete(UUID taskId);
  void setTaskIncomplete(UUID taskId);
  void toggleComplete(UUID taskId);
}
