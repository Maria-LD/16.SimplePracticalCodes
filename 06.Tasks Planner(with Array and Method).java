//with Array and Methods

import java.util.*;

public class TasksPlanner {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int[] tasksTime = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();

        int countCompleted = 0;
        int countIncompleted = 0;
        int countDropped = 0;

        while(!"End".equals(input)) {

            String[] command = input.split("\\s+");

            switch (command[0]) {

                case "Complete":
                    complete(tasksTime, command);
                    break;

                case "Change":
                    change(tasksTime, command);
                    break;

                case "Drop":
                    drop(tasksTime, command);
                    break;

                case "Count":

                    switch (command[1]) {

                        case "Completed":
                            countCompleted(tasksTime, countCompleted);
                            break;

                        case "Incomplete":
                            countIncompleted(tasksTime, countIncompleted);
                            break;

                        case "Dropped":
                            countDropped(tasksTime, countDropped);
                            break;

                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < tasksTime.length; i++) {
            if (tasksTime[i] > 0) {
                System.out.print(tasksTime[i] + " ");
            }
        }

    }

    public static void countDropped(int[] tasksTime, int countDropped) {
        for (int i = 0; i < tasksTime.length; i++) {
            if(tasksTime[i] == -1) {
                countDropped++;
            }
        }
        System.out.println(countDropped);
    }

    public static void countIncompleted(int[] tasksTime, int countIncompleted) {
        for (int i = 0; i < tasksTime.length; i++){
            if (tasksTime[i] > 0) {
                countIncompleted++;
            }
        }
        System.out.println(countIncompleted);
    }

    public static void countCompleted(int[] tasksTime, int countCompleted) {
        for (int i = 0; i < tasksTime.length; i++) {
            if(tasksTime[i] == 0) {
                countCompleted++;
            }
        }
        System.out.println(countCompleted);
    }

    public static void drop(int[] tasksTime, String[] command) {
        int indexToDrop = Integer.parseInt(command[1]);
        if (indexToDrop >= 0 && indexToDrop < tasksTime.length) {
            tasksTime[indexToDrop] = -1;
        }
    }

    public static void change(int[] tasksTime, String[] command) {
        int indexToChange = Integer.parseInt(command[1]);
        int timeToChange = Integer.parseInt(command[2]);
        if (indexToChange >= 0 && indexToChange < tasksTime.length) {
            tasksTime[indexToChange] = timeToChange;
        }
    }

    public static void complete(int[] tasksTime, String[] command) {
        int indexToComplete = Integer.parseInt(command[1]);
        if (indexToComplete >= 0 && indexToComplete < tasksTime.length) {
            tasksTime[indexToComplete] = 0;
        }
    }
}