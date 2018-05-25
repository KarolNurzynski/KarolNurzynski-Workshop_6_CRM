package pl.coderslab.workshop6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop6.entity.Task;
import pl.coderslab.workshop6.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    TaskService(TaskRepository taskRepository) {
        this.taskRepository=taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseGet(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task editTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
