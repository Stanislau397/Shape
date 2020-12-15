package edu.epam.figure.util;

public class IdGenerator {

    public static final long MIN_ID = Long.MIN_VALUE;
    public static final long MAX_ID = Long.MAX_VALUE;
    private static long counter;

    public static long generateId() {
        counter = counter + 1;

        if (MIN_ID + counter >= MAX_ID) {
            counter = 0;
        }
        return counter;
    }
}
