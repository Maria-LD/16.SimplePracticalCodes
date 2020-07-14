import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Zada4i3 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        List<String> contacts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            String[] command = input.split("\\s+");
            boolean hasToStop = false;

            switch (command[0]) {

                case "Add":
                    String contactToAdd = command[1];
                    int indexToAdd = Integer.parseInt(command[2]);
                    if (!contacts.contains(contactToAdd)) {
                        contacts.add(contactToAdd);
                    } else {
                        if(indexToAdd >= 0 && indexToAdd < contacts.size())
                        contacts.add(indexToAdd, contactToAdd);
                    }
                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(command[1]);
                    if (indexToRemove >= 0 && indexToRemove < contacts.size()) {
                        contacts.remove(indexToRemove);
                    }

                    break;

                case "Export":
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
                    try {
                        List<String> sub = contacts.subList(startIndex, startIndex + count);
                        for (int i = 0; i < sub.size(); i++) {
                            System.out.print(sub.get(i) + " ");
                        }
                        System.out.println();
                    } catch (Exception ex) {
                        List<String> sub = contacts.subList(startIndex, contacts.size());
                        for (int i = 0; i < sub.size(); i++) {
                            System.out.print(sub.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;

                case "Print":
                    if ("Normal".equals(command[1])) {
                        System.out.print("Contacts: ");
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.print(contacts.get(i) + " ");
                        }
                        hasToStop = true;

                    } else {
                        System.out.print("Contacts: ");
                        for (int i = contacts.size() - 1; i >= 0; i--) {
                            System.out.print(contacts.get(i) + " ");
                        }
                        hasToStop = true;
                    }
                    break;
            }

            if (hasToStop) {
                break;
            }
        }

    }
}