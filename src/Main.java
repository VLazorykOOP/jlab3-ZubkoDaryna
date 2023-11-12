import java.util.Scanner;

class Country {
    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public void Show() {
        System.out.println("Country Name: " + name);
        System.out.println("Population: " + population);
    }
}

class Republic extends Country {
    private String president;

    public Republic(String name, int population, String president) {
        super(name, population);
        this.president = president;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("President: " + president);
    }
}

class Monarchy extends Country {
    private String monarch;

    public Monarchy(String name, int population, String monarch) {
        super(name, population);
        this.monarch = monarch;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Monarch: " + monarch);
    }
}

class Kingdom extends Monarchy {
    private String capital;

    public Kingdom(String name, int population, String monarch, String capital) {
        super(name, population, monarch);
        this.capital = capital;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Capital: " + capital);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Country[] countries = new Country[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter information for country " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Population: ");
            int population = scanner.nextInt();
            scanner.nextLine();

            if (i == 0) {
                System.out.print("President: ");
                String president = scanner.nextLine();
                countries[i] = new Republic(name, population, president);
            } else if (i == 1) {
                System.out.print("Monarch: ");
                String monarch = scanner.nextLine();
                countries[i] = new Monarchy(name, population, monarch);
            } else {
                System.out.print("Monarch: ");
                String monarch = scanner.nextLine();
                System.out.print("Capital: ");
                String capital = scanner.nextLine();
                countries[i] = new Kingdom(name, population, monarch, capital);
            }
        }
        System.out.println("----------");

        scanner.close();

        for (Country country : countries) {
            System.out.println("Country data:");
            country.Show();
            System.out.println("----------");
        }
    }
}
