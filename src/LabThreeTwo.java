import java.util.Scanner;

abstract class Series {
    public abstract double calculateNthTerm(int n);

    public abstract double calculateSum(int n);
}
class Linear extends Series {
    private double firstTerm;
    private double commonDifference;

    public Linear(double firstTerm, double commonDifference) {
        this.firstTerm = firstTerm;
        this.commonDifference = commonDifference;
    }
    @Override
    public double calculateNthTerm(int n) {
        return firstTerm + (n - 1) * commonDifference;
    }

    @Override
    public double calculateSum(int n) {
        return (n * (2 * firstTerm + (n - 1) * commonDifference)) / 2;
    }
}

class Exponential extends Series {
    private double firstTerm;
    private double commonRatio;

    public Exponential(double firstTerm, double commonRatio) {//commonRatio-знаменник прогречії
        this.firstTerm = firstTerm;
        this.commonRatio = commonRatio;
    }
    @Override
    public double calculateNthTerm(int n) {
        return firstTerm * Math.pow(commonRatio, n - 1);
    }

    @Override
    public double calculateSum(int n) {
        return firstTerm * (1 - Math.pow(commonRatio, n)) / (1 - commonRatio);
    }
}

public class LabThreeTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Обчислення членів арифметичної та геометричної прогресії");

        System.out.println("Введіть перший член арифметичної прогресії:");
        double firstTermArith = scanner.nextDouble();

        System.out.println("Введіть різницю арифметичної прогресії:");
        double commonDifferenceArith = scanner.nextDouble();

        System.out.println("Введіть перший член геометричної прогресії:");
        double firstTermGeo = scanner.nextDouble();

        System.out.println("Введіть спільний знаменник геометричної прогресії:");
        double commonRatioGeo = scanner.nextDouble();

        System.out.println("Введіть номер члена прогресії для обчислення:");
        int n = scanner.nextInt();

        Series arithSeries = new Linear(firstTermArith, commonDifferenceArith);
        Series geoSeries = new Exponential(firstTermGeo, commonRatioGeo);

        System.out.println("Арифметична прогресія:");
        System.out.println(n + "-й член: " + arithSeries.calculateNthTerm(n));
        System.out.println("Сума перших " + n + " членів: " + arithSeries.calculateSum(n));

        System.out.println("Геометрична прогресія:");
        System.out.println(n + "-й член: " + geoSeries.calculateNthTerm(n));
        System.out.println("Сума перших " + n + " членів: " + geoSeries.calculateSum(n));

        scanner.close();
    }
}

