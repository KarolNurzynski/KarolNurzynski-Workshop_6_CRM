package pl.coderslab.workshop6.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="status")
@Getter @Setter @NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean activeStatus=false;

    private int sortingSequence;

    @OneToMany(mappedBy = "status")
    private List<Task> tasks;

}
