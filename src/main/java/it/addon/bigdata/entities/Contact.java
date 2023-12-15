package it.addon.bigdata.entities;

import jakarta.persistence.*;
import lombok.*;

// JPA
@Entity
@Table(name = "contacts")
// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "name")
    // @Minlength, etc..  => Validators
    @NonNull
    private String name;
}
