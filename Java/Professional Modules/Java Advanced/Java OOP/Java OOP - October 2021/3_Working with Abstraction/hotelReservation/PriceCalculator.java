package hotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private String season;
    private String discountType;
    private double multiplier;
    private double discountPercentage;
//    private enum Season {
//        Spring,
//        Summer,
//        Autumn,
//        Winter;
//    }
//    private enum DiscountType {
//        VIP,
//        SecondVisit,
//        None;
//    }

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculatePrice() {
        calculatePricePerDay(season);
        calculateDiscountPercentage(discountType);

        double priceWithoutDiscount = pricePerDay * numberOfDays;
        double finalPrice = priceWithoutDiscount - (priceWithoutDiscount * discountPercentage);
        return finalPrice;
    }

    private void calculatePricePerDay(String season) {
        switch (season) {
            case "Spring":
                multiplier = 2;
                break;

            case "Summer":
                multiplier = 4;
                break;

            case "Autumn":
                multiplier = 1;
                break;

            case "Winter":
                multiplier = 3;
                break;
        }
        pricePerDay = pricePerDay * multiplier;
    }

    private void calculateDiscountPercentage(String discountType) {
        switch (discountType) {
            case "VIP":
                discountPercentage = 0.20;
                break;

            case "SecondVisit":
                discountPercentage = 0.10;
                break;

            case "None":
                discountPercentage = 0.00;
                break;
        }
    }
}
