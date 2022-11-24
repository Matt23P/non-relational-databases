package repositories;

public interface Repository <T, id_T> {

    T add (T item);

    T get (T item);

    void remove (T item);

    void update (T item1);
}