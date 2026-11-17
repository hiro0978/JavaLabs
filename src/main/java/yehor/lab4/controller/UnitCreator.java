package yehor.lab4.controller;

/**
 * Спільний інтерфейс для всіх «створювачів» структурних підрозділів.
 *
 * @param <T> тип підрозділу, який створюється
 */
public interface UnitCreator<T> {

    T create(String name);
}
