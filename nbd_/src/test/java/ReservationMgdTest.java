import managers.ReservationManagerMgd;
import model.ParentMgd;
import model.ReservationMgd;
import model.SitterMgd;
import org.junit.Test;
import repositories.ParentRepositoryMgd;
import repositories.ReservationRepositoryMgd;
import repositories.SitterRepositoryMgd;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class ReservationMgdTest {

    private static final ReservationRepositoryMgd reservationRepositoryMgd = new ReservationRepositoryMgd();
    private static final ParentRepositoryMgd parentRepositoryMgd = new ParentRepositoryMgd();
    private static final SitterRepositoryMgd sitterRepositoryMgd = new SitterRepositoryMgd();

    ReservationManagerMgd reservationManagerMgd = new ReservationManagerMgd(reservationRepositoryMgd);

    @Test
    public void reservationAddTest(){
        ParentMgd parentMgd_1 = new ParentMgd("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        SitterMgd sitterMgd_1 = new SitterMgd("Katarzyna", "Nowak", SitterMgd.SitterType.HOUSEKEEPER, 110, "Cooking", 7);
        ParentMgd parentMgd_2 = new ParentMgd("Wojciech Stefanowski", "Lodz Politechniki1", "211566677", 5);
        SitterMgd sitterMgd_2 = new SitterMgd("Krzysztof", "Kowalski", SitterMgd.SitterType.ACADEMIC, 100, "Maths", 10);
        long collectionSize = reservationManagerMgd.getSize();

        assertNotNull(parentRepositoryMgd.add(parentMgd_1));
        assertNotNull(sitterRepositoryMgd.add(sitterMgd_1));
        assertNotNull(parentRepositoryMgd.add(parentMgd_2));
        assertNotNull(sitterRepositoryMgd.add(sitterMgd_2));

        assertTrue(reservationManagerMgd.add(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parentMgd_1, sitterMgd_1));
        assertEquals(collectionSize+1, reservationManagerMgd.getSize());
        assertTrue(reservationManagerMgd.add(LocalDate.of(2022, 11, 25), LocalTime.of(7, 30), LocalTime.of(20, 20), parentMgd_2, sitterMgd_2));
        assertEquals(collectionSize+2, reservationManagerMgd.getSize());
        assertFalse(reservationManagerMgd.add(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parentMgd_2, sitterMgd_1));
        assertEquals(collectionSize+2, reservationManagerMgd.getSize());
    }

    @Test
    public void reservationGetTest(){
        ParentMgd parentMgd = new ParentMgd("Mateusz Przybylski", "Lipinki Laczna43", "694202137", 8);
        SitterMgd sitterMgd = new SitterMgd("Katarzyna", "Nowak", SitterMgd.SitterType.HOUSEKEEPER, 110, "Cooking", 7);
        ReservationMgd reservationMgd = new ReservationMgd(LocalDate.of(2022, 12, 12), LocalTime.of(9, 0), LocalTime.of(20, 0), parentMgd, sitterMgd);

        assertNotNull(parentRepositoryMgd.add(parentMgd));
        assertNotNull(sitterRepositoryMgd.add(sitterMgd));
        assertNotNull(reservationRepositoryMgd.add(reservationMgd));

        assertEquals(reservationMgd, reservationRepositoryMgd.get(reservationMgd));
        assertEquals(reservationMgd.getEntityId().getUuid(), reservationRepositoryMgd.get(reservationMgd).getEntityId().getUuid());
        assertEquals(reservationMgd, reservationRepositoryMgd.getByEntityId(reservationMgd.getEntityId()));
        assertEquals(reservationMgd.getDate(), reservationRepositoryMgd.get(reservationMgd).getDate());
        assertEquals(reservationMgd.getStartTime(), reservationRepositoryMgd.get(reservationMgd).getStartTime());
        assertEquals(reservationMgd.getEndTime(), reservationRepositoryMgd.get(reservationMgd).getEndTime());
        assertEquals(reservationMgd.getParent(), reservationRepositoryMgd.get(reservationMgd).getParent());
        assertEquals(reservationMgd.getSitter(), reservationRepositoryMgd.get(reservationMgd).getSitter());

    }

    @Test
    public void updateReservationTest(){

    }

    @Test
    public void reservationRemoveTest(){

    }
}
