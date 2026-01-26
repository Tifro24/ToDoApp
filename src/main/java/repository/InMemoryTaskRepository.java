package repository;

import domain.Task;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryTaskRepository implements TaskRepository{
   private HashMap<UUID, Task> taskMap = new HashMap<>();

    @Override
    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskMap.remove(taskId);
    }

    @Override
    public Task getTaskById(UUID taskId) {
        Task task = taskMap.get(taskId);
        return (task != null) ? task : null;
    }

    @Override
    public String getTaskTitleById(UUID taskId) {
        Task task = taskMap.get(taskId);
        return task.getTitle();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskMap.values()
                .stream()
                .sorted(Comparator.comparing(Task::getCreatedAt))
                .collect(Collectors.toList());
    }

    @Override
    public void setTaskTitleById(UUID taskId, String title) {
        Task task = taskMap.get(taskId);
        if (task != null){
            task.setTitle(title);
        }
    }

    @Override
    public void setTaskComplete(UUID taskId) {
        Task task = taskMap.get(taskId);
        task.setComplete();
    }

    @Override
    public void setTaskIncomplete(UUID taskId) {
        Task task = taskMap.get(taskId);
        task.setIncomplete();
    }

    @Override
    public void toggleComplete(UUID taskId) {
        Task task = taskMap.get(taskId);
        task.toggleCompleted();
    }
}
