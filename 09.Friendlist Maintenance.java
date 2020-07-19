import java.util.*;
import java.util.stream.Collectors;

public class FriendlistMaintenance {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        List<String> friends = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        int countBlacklisted = 0;
        int countError = 0;

        while(!input.equals("Report")) {

            String[] command =input.split("\\s+");

            switch (command[0]) {

                case "Blacklist":
                    String nameBlacklisted = command[1];
                    if (friends.contains(nameBlacklisted)) {
                        int indexBlackListed = friends.indexOf(nameBlacklisted);
                        friends.set(indexBlackListed, "Blacklisted");
                        System.out.println(nameBlacklisted + " was blacklisted.");
                        countBlacklisted++;
                    } else {
                        System.out.println(nameBlacklisted + " was not found.");
                    }
                    break;

                case "Error":
                    int indexError = Integer.parseInt(command[1]);
                    String nameError = friends.get(indexError);
                    if (indexError >= 0 && indexError < friends.size()) {
                        if (!nameError.equals("Blacklisted") &&
                                !nameError.equals("Lost")) {
                            friends.set(indexError, "Lost");
                            System.out.println(nameError + " was lost due to an error.");
                            countError++;
                        }
                    }

                    break;

                case "Change":
                    int indexChange = Integer.parseInt(command[1]);
                    String nameChange = command[2];
                    if (indexChange >= 0 && indexChange < friends.size()) {
                        String oldName = friends.get(indexChange);
                        friends.set(indexChange, nameChange);
                        System.out.println(oldName + " changed his username to " + nameChange + ".");
                    }

                    break;

            }
            input = scanner.nextLine();
        }

        System.out.println("Blacklisted names: " + countBlacklisted);
        System.out.println("Lost names: " + countError);

        for (String name: friends) {
            System.out.print(name + " ");
        }

    }
}