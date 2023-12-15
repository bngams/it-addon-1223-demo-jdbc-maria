package it.addon.bigdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// JPA
@Entity
@Table(name = "contacts")
// Lombok
@Data
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
