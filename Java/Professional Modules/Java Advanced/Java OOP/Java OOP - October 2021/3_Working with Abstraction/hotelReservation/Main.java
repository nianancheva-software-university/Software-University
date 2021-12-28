package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discountType = tokens[3];

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
        double price = priceCalculator.calculatePrice();

        System.out.printf("%.2f", price);
    }
}
