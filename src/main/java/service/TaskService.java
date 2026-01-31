package service;

import domain.Task;
import repository.InMemoryTaskRepository;
import repository.TaskRepository;

import java.util.List;
import java.util.UUID;


public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void addTask(String title){
        if(title.isBlank()){
            throw new IllegalArgumentException("Title must not be blank");
        }
        else{
            Task task = new Task(title);
            taskRepository.addTask(task);
        }

    }

    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(UUID taskId){
        Task task = taskRepository.getTaskById(taskId) ;
        if(task == null){
            throw new IllegalArgumentException("Task not found");
        }
        else{
            return task;
        }
    }

    public void deleteTask(UUID taskId){
        Task task = getTaskById(taskId);
        if(task != null){
            taskRepository.deleteTask(taskId);
        }
    }

    public void updateTaskTitle(String title, UUID taskId){
        taskRepository.setTaskTitleById(taskId, title);
    }

    public void setTaskComplete(UUID taskId){
        taskRepository.setTaskComplete(taskId);
    }

    public void setTaskIncomplete(UUID taskId){
        taskRepository.setTaskIncomplete(taskId);
    }

    public void toggleComplete(UUID taskId){
        taskRepository.toggleComplete(taskId);
    }
}
