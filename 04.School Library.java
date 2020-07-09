import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class School Library {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        List<String> books = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"Done".equals(input)) {

            String tokens[] = input.split("\\|");
            String command = tokens[0].trim();
            String book = tokens[1].trim();

            switch (command) {

                case "Add Book":
                    if (!books.contains(book)) {
                        books.add(0, book);
                    }
                    break;

                case "Take Book":
                    books.remove(book);
                    break;

                case "Swap Books":
                    String newBook = tokens[2].trim();
                    if (books.contains(book) && books.contains(newBook)) {
                        int indexBook = books.indexOf(book);
                        int indexNewBook = books.indexOf(newBook);
                        Collections.swap(books, indexBook, indexNewBook);
                    }
                    break;

                case "Insert Book":
                    books.add(book);
                    break;

                case "Check Book":
                    int indexToCheck = Integer.parseInt(book);
                    for (int i = 0; i < books.size(); i++) {
                        if (i == indexToCheck) {
                            System.out.println(books.get(i));
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < books.size(); i++) {
            if (i == books.size() - 1) {
                System.out.print(books.get(i));
            } else {
                System.out.print(books.get(i) + ", ");
            }
        }

    }
}