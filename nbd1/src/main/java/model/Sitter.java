package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Sitter")
public class Sitter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Sitter_ID")
    private Long sitterId;

    @Column(name="First name")
    private String firstName;

    @Column(name="Last name")
    private String lastName;

    @Column(name = "Base price")
    private double basePrice;

    public Sitter(Long sitterId, String firstName, String lastName, double basePrice) {
        this.sitterId = sitterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
    }

    protected Sitter(){

    }



}
