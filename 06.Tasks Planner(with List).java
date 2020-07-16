//with List

import java.util.*;
import java.util.stream.Collectors;

public class Zada4i3 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> tasksTime = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        int countCompleted = 0;
        int countIncompleted = 0;
        int countDropped = 0;

        while(!"End".equals(input)) {

            String[] command = input.split("\\s+");

            switch (command[0]) {

                case "Complete":
                    int indexToComplete = Integer.parseInt(command[1]);
                    if (indexToComplete >= 0 && indexToComplete < tasksTime.size()) {
                        tasksTime.set(indexToComplete, 0);
                    }
                    break;

                case "Change":
                    int indexToChange = Integer.parseInt(command[1]);
                    int timeToChange = Integer.parseInt(command[2]);
                    if (indexToChange >= 0 && indexToChange < tasksTime.size()) {
                        tasksTime.set(indexToChange, timeToChange);
                    }
                    break;

                case "Drop":
                    int indexToDrop = Integer.parseInt(command[1]);
                    if (indexToDrop >= 0 && indexToDrop < tasksTime.size()) {
                        tasksTime.set(indexToDrop, -1);
                    }
                    break;

                case "Count":

                    switch (command[1]) {

                        case "Completed":
                            for (int i = 0; i < tasksTime.size(); i++) {
                                if(tasksTime.get(i) == 0) {
                                    countCompleted++;
                                }
                            }
                            System.out.println(countCompleted);
                            break;

                        case "Incomplete":
                            for (int i = 0; i < tasksTime.size(); i++){
                                if (tasksTime.get(i) > 0) {
                                    countIncompleted++;
                                }
                            }
                            System.out.println(countIncompleted);
                            break;

                        case "Dropped":
                            for (int i = 0; i < tasksTime.size(); i++) {
                                if(tasksTime.get(i) == -1) {
                                    countDropped++;
                                }
                            }
                            System.out.println(countDropped);
                            break;

                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < tasksTime.size(); i++) {
            if (tasksTime.get(i) > 0) {
                System.out.print(tasksTime.get(i) + " ");
            }
        }

    }
}