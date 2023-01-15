package me.zdziszkee.stack;

import java.util.Arrays;
import java.util.Optional;

public class DefaultStack<T> {

    private final T[] array;

    private int cursor = 0;

    public DefaultStack(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public boolean push(final T type) {
        if (isFull()) {
            return false;
        }
        array[cursor] = type;
        cursor++;
        return true;
    }

    public Optional<T> pop() {
        if (cursor == 0) {
            return Optional.empty();
        }
        final T element = array[cursor];
        array[cursor] = null;
        cursor--;
        return Optional.of(element);
    }

    public boolean contains(final T type) {
        for (final T element : array) {
            if (element.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        return cursor >= array.length;
    }

    public boolean isEmpty() {
        return !isFull();
    }

}
