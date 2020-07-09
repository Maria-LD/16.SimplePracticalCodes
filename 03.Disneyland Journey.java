import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DisneylandJourney {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int costOfJourney = Integer.parseInt(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double savedMoney = 0;

        for (int i = 1; i <= months; i++) {

            if (i != 1 && i % 2 != 0) {
                double clothesAndShoes = 0.16 * savedMoney;
                savedMoney -= clothesAndShoes;
            }

            if (i % 4 == 0) {
                double bonus = 0.25 * savedMoney;
                savedMoney += bonus;
            }

            savedMoney += (0.25 * costOfJourney);
        }


        if (savedMoney > costOfJourney) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2f dollars for souvenirs.",
                    savedMoney - costOfJourney);
        } else {
            System.out.printf("Sorry. You need %.2f dollars more.", costOfJourney - savedMoney);
        }

    }
}