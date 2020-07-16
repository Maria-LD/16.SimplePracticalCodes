import java.util.*;
import java.util.stream.Collectors;

public class TanksCollector {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        List<String> tanks = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(", ");

            switch (command[0]) {

                case "Add":
                    if (tanks.contains(command[1])) {
                        System.out.println("Tank is already bought");
                    } else {
                        System.out.println("Tank successfully bought");
                        tanks.add(command[1]);
                    }
                    break;

                case "Remove":
                    if (tanks.contains(command[1])) {
                        System.out.println("Tank successfully sold");
                        tanks.remove(command[1]);
                    } else {
                        System.out.println("Tank not found");
                    }
                    break;

                case "Remove At":
                    int indexToRemoveAt = Integer.parseInt(command[1]);
                    if (indexToRemoveAt >= 0 && indexToRemoveAt < tanks.size()) {
                        tanks.remove(indexToRemoveAt);
                        System.out.println("Tank successfully sold");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;

                case "Insert":
                    int indexToInsert = Integer.parseInt(command[1]);
                    String nameToInsert = command[2];
                    if (indexToInsert >= 0 && indexToInsert < tanks.size()) {

                        if (!tanks.contains(nameToInsert)) {
                            tanks.add(indexToInsert, nameToInsert);
                            System.out.println("Tank successfully bought");
                        } else {
                            System.out.println("Tank is already bought");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;

            }
        }

        for (int i = 0; i < tanks.size(); i++) {
            if (i == tanks.size() - 1) {
                System.out.print(tanks.get(i));
            } else {
                System.out.print(tanks.get(i) + ", ");
            }

        }

    }
}