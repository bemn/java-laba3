package ru.otavin.taskclasses;

public final class Drob extends Number {
    private final int numerator;
    private final int denominator;

    public Drob(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Division by zero!");
        }
        if (denominator < 0) {
            numerator = -1 * numerator;
            denominator = -1 * denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Drob sum(Drob other) {
        return new Drob(
            numerator * other.denominator + other.numerator * denominator,
            denominator * other.denominator
        );
    }

    public Drob sum(int number) {
        return new Drob(
            numerator + number * denominator,
            denominator
        );
    }

    public static double sum(String line) {
        String[] values = line.split("\\+");
        double result = 0;

        for (String value : values) {
            value = value.trim();
            if (value.contains("/")) {
                String[] parts = value.split("/");
                int numerator = Integer.parseInt(parts[0].trim());
                int denominator = Integer.parseInt(parts[1].trim());

                result += new Drob(numerator, denominator).doubleValue();
            } else {
                result += Double.parseDouble(value);
            }
        }
        return result;
    }

    public Drob minus(Drob other) {
        return new Drob(
            numerator * other.denominator - other.numerator * denominator,
            denominator * other.denominator
        );
    }

    public Drob minus(int number) {
        return new Drob(
            numerator - number * denominator,
            denominator
        );
    }

    public Drob multiply(Drob other) {
        return new Drob(
            numerator * other.numerator,
            denominator * other.denominator
        );
    }

    public Drob multiply(int number) {
        return new Drob(
            numerator * number,
            denominator
        );
    }

    public Drob div(Drob other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return new Drob(
            numerator * other.denominator,
            denominator * other.numerator
        );
    }

    public Drob div(int number) {
        if (number == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return new Drob(
            numerator,
            denominator * number
        );
    }


    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Drob other = (Drob) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public Drob clone() {
        return new Drob(numerator, denominator);
    }
}
