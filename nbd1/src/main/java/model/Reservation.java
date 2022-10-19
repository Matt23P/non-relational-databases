package model;

import java.time.LocalDateTime;
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
    private Long reservation_id;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Start hour")
    private LocalTime startHour;

    @Column(name = "End hour")
    private LocalTime endHour;

    @ManyToOne
    @JoinColumn(name = "Sitter_ID")
    private Sitter sitter;

    @OneToOne
    @JoinColumn(name = "Parent_ID")
    private Parent parent;

    public Reservation(Long reservation_id, LocalDate date, LocalTime startHour, LocalTime endHour, Sitter sitter, Parent parent) {
        this.reservation_id = reservation_id;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.sitter = sitter;
        this.parent = parent;
    }

    protected Reservation() {

    }
}
