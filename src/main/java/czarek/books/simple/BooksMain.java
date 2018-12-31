package czarek.books.simple;

import java.util.Scanner;

public class BooksMain {

    public static void main(String[] args) {
        String[] books = new String[20];
        String[] authors = new String[20];
        Scanner input = new Scanner(System.in);

        boolean petla = true;

        while (petla) {
            menu();
            int wybor = input.nextInt();
            input.skip("\n");
            switch (wybor) {
                case 1:
                    addBook(books,
                            authors,
                            input);
                    break;
                case 2:
                    print(books,
                            authors,
                            input);
                    break;
                case 3:
                    print(books,
                            authors);
                    break;
                case 4:
                    remove(books,
                            authors,
                            input);
                    break;
                case 5:
                    remove(books,
                            authors);
                    break;
                case 6:
                    findByAuthor(books,
                            authors,
                            input);
                    break;

                case 7:
                    count(books);
                    break;
                case 8:
                    findLongestTitle(books);
                    break;
                case 9:
                    petla = false;
            }

        }

    }

    public static void menu() {
        System.out.println("Witam");
        System.out.println("1. Dodanie nowej książki");
        System.out.println("2. Informacje o książce");
        System.out.println("3. Informacje o wszystkich ksiązkach");
        System.out.println("4. Usunięcie książki");
        System.out.println("5. Usunięcie wszystkich książek");
        System.out.println("6. Wypisanie wszystkich książek autora");
        System.out.println("7. Liczba książek w zbiorze");
        System.out.println("8. Wyświetlenie najdłuższego tytułu");
        System.out.println("9. Wyjście");

    }

    public static void addBook(String[] books, String[] authors, Scanner scanner) {
        System.out.println("Podaj miejsce na liscie:");
        int index = scanner.nextInt();
        scanner.skip("\n");
        System.out.println("Podaj tytuł: ");
        books[index] = scanner.nextLine();
        System.out.println("Podaj autora: ");
        authors[index] = scanner.nextLine();
    }

    public static void print(String[] books, String[] authors, Scanner scanner) {
        System.out.println("Podaj numer książki:");
        int index = scanner.nextInt();
        System.out.println(books[index] + "\n" + authors[index]);
    }

    private static void print(String[] books, String[] authors) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(i + "." + books[i] + " - " + authors[i]);
            }
        }
    }

    private static void remove(String[] books, String[] authors, Scanner scanner) {
        System.out.println("Którą pozycję usunąć:");
        int index = scanner.nextInt();
        books[index] = null;
        authors[index] = null;
    }

    private static void remove(String[] books, String[] authors) {
        for (int index = 0; index < books.length; index++) {
            books[index] = null;
            authors[index] = null;
        }
    }

    public static void findByAuthor(String[] books, String[] authors, Scanner scanner) {
        System.out.println("Podaj autora");
        String input = scanner.nextLine();
        for (int i = 0; i < authors.length; i++) {
            if (input.equals(authors[i])) {
                System.out.println(books[i]);
            }
        }
    }

    public static void count(String[] books) {
        int number = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                number++;
            }
        }
        System.out.println("Liczba książek to " + number);

    }

    public static void findLongestTitle(String[] books) {
        int dlugosc = 0;
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (dlugosc < books[i].length()) {
                    dlugosc = books[i].length();
                    index = i;
                }
            }
        }
        System.out.println("Najdłuższy tytuł:" + books[index]);
    }
}
