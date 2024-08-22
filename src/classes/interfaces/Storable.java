package classes.interfaces;

import java.util.Objects;

public interface Storable<T> {
    void save(T object, T[] objectArray);
    void delete(T object, T[] objectArray);
}
