package pl.coderslab.workshop6.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="priority")
@Getter @Setter @NoArgsConstructor
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean activeStatus = false;

    @OneToMany(mappedBy = "priority")
    private List<Task> tasks;

}
