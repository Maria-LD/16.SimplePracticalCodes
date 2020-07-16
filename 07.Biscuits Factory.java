import java.util.*;

public class BiscuitsFactory {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());
        int biscuitsCompetitor = Integer.parseInt(scanner.nextLine());

        int productionThirdDay = 0;
        int productionTheRestDays = 0;

        for (int i = 1; i <= 30; i++) {
            if (i%3 == 0) {
                productionThirdDay += 0.75 * (biscuitsPerDay * workersCount);
            } else {
                productionTheRestDays += biscuitsPerDay * workersCount;
            }
        }

        int wholeProduction = productionThirdDay + productionTheRestDays;
        int difference = wholeProduction - biscuitsCompetitor;

        //difference - x%
        //biscuitsCompetitor - 100%
        //x * biscuitsCompetitor = 100 * difference
        //x = (100 * difference) / biscuitsCompetitor

        double percent = (100 * difference) / (double)biscuitsCompetitor;

        System.out.printf("You have produced %d biscuits for the past month.%n", wholeProduction);
        if (percent > 0) {
            System.out.printf("You produce %.2f percent more biscuits.", percent);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", Math.abs(percent));
        }

    }
}