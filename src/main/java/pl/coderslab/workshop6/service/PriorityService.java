package pl.coderslab.workshop6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop6.entity.Priority;
import pl.coderslab.workshop6.repository.PriorityRepository;

import java.util.List;

@Service
public class PriorityService {

    PriorityRepository priorityRepository;

    @Autowired
    PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository=priorityRepository;
    }

    public List<Priority> findAllPriorities() {
        return priorityRepository.findAll();
    }

    public List<Priority> findAllActivePriorities() {
        return priorityRepository.findAllByActiveStatusIsTrue();
    }

    public Priority findPriorityById(Long id) {
        return priorityRepository.findById(id).orElseGet(null);
    }

    public Priority savePriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public Priority editPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public void deletePriority(Priority priority) {
        priorityRepository.delete(priority);
    }
}
