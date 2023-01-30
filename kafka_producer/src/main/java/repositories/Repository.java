package repositories;

public interface Repository <T> {

    T add(T item);

    T get(T item);

    void remove(T item);

    boolean update(T item1);
}