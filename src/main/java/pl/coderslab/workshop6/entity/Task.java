package pl.coderslab.workshop6.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="task")
@Getter @Setter @NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    private String topic;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    private String description;

    @ManyToOne
    @JoinColumn(name="priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;


}
