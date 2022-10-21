package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Sitter")
@Access(AccessType.FIELD)
public class Sitter extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sitter_ID")
    private Long sitterId;

    @Column(name = "First_name")
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Base_price")
    private double basePrice;

    public Sitter(String firstName, String lastName, double basePrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
    }

    protected Sitter() {

    }

}
