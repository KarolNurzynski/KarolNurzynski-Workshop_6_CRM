package pl.coderslab.workshop6.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="project")
@Getter @Setter @NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    private String name;

    private String description;

    @URL
    private String www;

    private String projectId;

    @ManyToMany
    private List<User> users;

    private boolean activeStatus = false;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

}
