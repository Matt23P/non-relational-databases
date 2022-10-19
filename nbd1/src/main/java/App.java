import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("BABYSITTER")
                .createEntityManager();
    }
}
