package model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Reservation")
@Access(AccessType.FIELD)
public class Reservation extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reservation_ID")
    private Long reservationId;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Start_hour")
    private LocalTime startHour;

    @Column(name = "End_hour")
    private LocalTime endHour;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Sitter_ID")
    private Sitter sitter;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Parent_ID")
    private Parent parent;

    //Reservation with basic Sitter class
    public Reservation(LocalDate date, LocalTime startHour, LocalTime endHour, Sitter sitter, Parent parent) {
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.sitter = sitter;
        this.parent = parent;
    }

    //Reservation with Housekeeper type Sitter
    public Reservation(LocalDate date, LocalTime startHour, LocalTime endHour, Housekeeper sitter, Parent parent) {
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.sitter = sitter;
        this.parent = parent;
    }

    //Reservation with Academic type Sitter
    public Reservation(LocalDate date, LocalTime startHour, LocalTime endHour, Academic sitter, Parent parent) {
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.sitter = sitter;
        this.parent = parent;
    }

    protected Reservation() {

    }
}
