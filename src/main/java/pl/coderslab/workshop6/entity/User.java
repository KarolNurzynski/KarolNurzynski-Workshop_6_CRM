package pl.coderslab.workshop6.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="user")
@Setter @Getter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    private String firstName;

    private String lastName;

    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Project> projects;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

}
