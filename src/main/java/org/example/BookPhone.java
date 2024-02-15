package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookPhone {
    public static void main(String[] args) {
        Map<String, List<Integer>> phoneBook = new HashMap<>();

        // Телефонная книга
        addContact(phoneBook, "Иванов", 123456789);
        addContact(phoneBook, "Буржуй", 1234562323);
        addContact(phoneBook, "Отец", 987654321);
        addContact(phoneBook, "Иванов", 987654321);
        addContact(phoneBook, "Буржуй", 880055535);
        addContact(phoneBook, "Отец", 851236548);
        addContact(phoneBook, "Отец", 456548788);

        printPhoneBook(phoneBook);
    }

    private static void addContact(Map<String, List<Integer>> phoneBook, String name, int phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }
    private static void printPhoneBook(Map<String, List<Integer>> phoneBook) {
        phoneBook.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.print(entry.getKey() + ": ");
                    entry.getValue().forEach(number -> System.out.print(number + " "));
                    System.out.println();
                });
    }


}


