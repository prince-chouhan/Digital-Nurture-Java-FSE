package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DataStructuresAndAlgorithms.Exercise6;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(1, "Java", "Author1"),
                new Book(2, "DSA", "Author2"),
                new Book(3, "Spring", "Author3")
        };

        Arrays.sort(books, Comparator.comparing(b -> b.title));

        Book book = binarySearch(books, "Spring");

        if (book != null) {
            System.out.println(book.title);
        }
    }
}