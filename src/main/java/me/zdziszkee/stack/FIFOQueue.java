package me.zdziszkee.stack;

import java.util.Arrays;
import java.util.Optional;

public class FIFOQueue<T> {

    private final T[] array;

    private int frontCursor = 0;

    private int backCursor = 0;

    public FIFOQueue(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public boolean enqueue(T type) {
        if (isFull()) {
            return false;
        }
        array[backCursor] = type;
        backCursor++;
        return true;
    }

    public Optional<T> dequeue() {
        if (frontCursor > backCursor) {
            return Optional.empty();
        }
        final T element = array[frontCursor];
        array[frontCursor] = null;
        if (frontCursor == backCursor) {
            frontCursor = 0;
            backCursor = 0;
        } else {
            frontCursor++;
        }
        return Optional.of(element);
    }

    public boolean isFull() {
        return backCursor >= array.length;
    }

    public boolean isEmpty() {
        return !isFull();
    }

}
