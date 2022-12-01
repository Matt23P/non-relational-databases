import managers.ReservationManager;
import model.Parent;
import model.Reservation;
import model.Sitter;
import org.junit.Test;
import repositories.ParentRepository;
import repositories.ReservationRepository;
import repositories.SitterRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationTest {

    private static final ReservationRepository reservationRepository = new ReservationRepository();
    private static final ParentRepository parentRepository = new ParentRepository();
    private static final SitterRepository sitterRepository = new SitterRepository();

    ReservationManager reservationManager = new ReservationManager(reservationRepository);

    @Test
    public void reservationAddTest(){
        Parent parent_1 = new Parent("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        Sitter sitter_1 = new Sitter("Katarzyna", "Nowak", Sitter.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);
        Parent parent_2 = new Parent("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5);
        Sitter sitter_2 = new Sitter("Krzysztof", "Kowalski", Sitter.SitterType.ACADEMIC, 100, "Maths", 10, true);
        long collectionSize = reservationManager.getSize();

        assertNotNull(parentRepository.add(parent_1));
        assertNotNull(sitterRepository.add(sitter_1));
        assertNotNull(parentRepository.add(parent_2));
        assertNotNull(sitterRepository.add(sitter_2));

        assertTrue(reservationManager.add(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parent_1, sitter_1));
        assertEquals(collectionSize+1, reservationManager.getSize());
        assertTrue(reservationManager.add(LocalDate.of(2022, 11, 25), LocalTime.of(7, 30), LocalTime.of(20, 20), parent_2, sitter_2));
        assertEquals(collectionSize+2, reservationManager.getSize());
        assertFalse(reservationManager.add(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parent_2, sitter_1));
        assertEquals(collectionSize+2, reservationManager.getSize());
    }

    @Test
    public void reservationGetTest(){
        Parent parent = new Parent("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        Sitter sitter = new Sitter("Katarzyna", "Nowak", Sitter.SitterType.HOUSEKEEPER, 110, "Cooking", 7, true);
        Reservation reservation = new Reservation(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parent, sitter);

        assertNotNull(parentRepository.add(parent));
        assertNotNull(sitterRepository.add(sitter));
        assertNotNull(reservationRepository.add(reservation));

        assertEquals(reservation.getEntityId().getUuid(), reservationRepository.get(reservation).getEntityId().getUuid());
        assertEquals(reservation.getEntityId().getUuid(), reservationRepository.getByEntityId(reservation.getEntityId()).getEntityId().getUuid());
        assertEquals(reservation.getDate(), reservationRepository.get(reservation).getDate());
        assertEquals(reservation.getStartTime(), reservationRepository.get(reservation).getStartTime());
        assertEquals(reservation.getEndTime(), reservationRepository.get(reservation).getEndTime());
        assertEquals(reservation.getParent().getEntityId().getUuid(), reservationRepository.get(reservation).getParent().getEntityId().getUuid());
        assertEquals(reservation.getSitter().getEntityId().getUuid(), reservationRepository.get(reservation).getSitter().getEntityId().getUuid());

    }

    @Test
    public void updateReservationTest(){

    }

    @Test
    public void reservationRemoveTest(){

    }
}