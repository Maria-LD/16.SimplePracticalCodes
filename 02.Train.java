import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.stream.Collectors;


public class Zada4i1 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputData.length; i++) {
            numbers.add(Integer.parseInt(inputData[i]));
        }
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] data = input.split("\\s+");

            if (data.length == 2) {
                numbers.add(Integer.parseInt(data[1]));
            } else {
                int passengersToAdd = Integer.parseInt(data[0]);

                for (int i = 0; i < numbers.size(); i++) {
                    int currentElement = numbers.get(i);

                    if (currentElement + passengersToAdd <= maxCapacity) {
                        numbers.set(i, currentElement + passengersToAdd);
                        break;
                    }

                }

            }

            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]", ""));
    }
}