package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 100)
    private String major;

    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false, length = 100)
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_filiere", nullable = false)
    private Filiere  filiere;

    //adding the relationship between the student and the course
    @OneToMany(mappedBy = "student")
    private List<Inscription> inscriptions;
    }
