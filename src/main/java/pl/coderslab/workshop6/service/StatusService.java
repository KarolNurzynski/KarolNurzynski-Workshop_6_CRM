package pl.coderslab.workshop6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop6.entity.Status;
import pl.coderslab.workshop6.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {

    StatusRepository statusRepository;

    @Autowired
    StatusService(StatusRepository statusRepository) {
        this.statusRepository=statusRepository;
    }

    public List<Status> findAllStatus() {
        return statusRepository.findAll();
    }

    public List<Status> findAllActiveStatus() {
        return statusRepository.findAllByActiveStatusIsTrue();
    }

    public Status findStatusById(Long id) {
        return statusRepository.findById(id).orElseGet(null);
    }

    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status editStatus(Status status) {
        return statusRepository.save(status);
    }

    public void deleteStatus(Status status) {
        statusRepository.delete(status);
    }
}
