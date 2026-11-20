package ru.otavin.taskclasses;

import java.util.Random;

public final class Secret {
    private static final Random random = new Random();

    private final String text;
    private final String keeperName;
    private final Secret previous;
    private Secret next;
    private final int order;
    private final int originalLength;

    // Создание секрета
    public Secret(String keeperName, String text) {
        if (keeperName == null || keeperName.isEmpty())
            throw new IllegalArgumentException("Имя хранителя не может быть пустым!");
        if (text == null || text.isEmpty()) 
            throw new IllegalArgumentException("Секрет не может быть пустым!");

        this.keeperName = keeperName;
        this.text = text;
        this.previous = null;
        this.order = 1;
        this.originalLength = text.length();

        System.out.println(keeperName + ": " + text);
    }

    // Передача секрета
    public Secret(Secret source, String newKeeperName) {
        if (newKeeperName == null || newKeeperName.isEmpty())
            throw new IllegalArgumentException("Имя хранителя не может быть пустым!");
        if (source.next != null)
            throw new IllegalStateException("Секрет уже передан другому человеку!");

        this.keeperName = newKeeperName;
        this.previous = source;
        this.order = source.order + 1;
        this.originalLength = source.originalLength;

        // Порча секрета
        int x = random.nextInt((originalLength / 10) + 1);
        this.text = addRandomCharacters(source.text, x);
        source.next = this;

        System.out.println(source.keeperName + " сказал, что " + source.text);
    }

    private String addRandomCharacters(String text, int count) {
        StringBuilder result = new StringBuilder(text);
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (int i = 0; i < count; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            int position = random.nextInt(result.length() + 1);
            result.insert(position, randomChar);
        }
        return result.toString();
    }


    public int getOrder() {
        return order;
    }

    public int getNextCount() {
        int count = 0;
        Secret current = next;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String getKeeperName(int n) {
        Secret current = this;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                current = current.next;
                if (current == null) return null;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                current = current.previous;
                if (current == null) return null;
            }
        }
        return current.keeperName;
    }

    public int getTextLengthDifference(int n) {
        Secret current = this;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                current = current.next;
                if (current == null) return -1;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                current = current.previous;
                if (current == null) return -1;
            }
        }
        return current.text.length() - this.text.length();
    }

    public String toString() {
        return keeperName + ": это секрет!";
    }
}