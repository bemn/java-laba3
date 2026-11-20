package ru.otavin.taskclasses;


public final class Imya {
    private final String firstName;
    private final String surname;
    private final String middleName;

    // Только личное имя
    public Imya(String firstName) {
        this(firstName, null, null);
    }

    // Личное имя и фамилия
    public Imya(String firstName, String surname) {
        this(firstName, surname, null);
    }

    // Все три параметра
    public Imya(String firstName, String surname, String middleName) {
        this.firstName = clean(firstName);
        this.surname = clean(surname);
        this.middleName = clean(middleName);

        if (this.firstName == null && this.surname == null && this.middleName == null) {
            throw new IllegalArgumentException("Имя должно содержать хотя бы одно непустое значение!");
        }
    }

    // Проверка и очистка строки
    private static String clean(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return value.trim();
    }

    public static Imya create(String firstName, String surname, String middleName) {
        return new Imya(firstName, surname, middleName);
    }

    public String toString() {
        String result = "";

        if (firstName != null) {
            result += firstName;
        }
        if (middleName != null) {
            if (!result.isEmpty()) result += " ";
            result += middleName;
        }
        if (surname != null) {
            if (!result.isEmpty()) result += " ";
            result += surname;
        }
        return result;
    }
}
