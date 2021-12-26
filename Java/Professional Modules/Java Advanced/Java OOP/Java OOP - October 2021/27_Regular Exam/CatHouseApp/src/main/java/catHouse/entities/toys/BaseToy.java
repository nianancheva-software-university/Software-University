package catHouse.entities.toys;

public abstract class BaseToy implements Toy{
    private int softness;
    private double price;

    protected BaseToy(int softness, double price) {
        this.setSoftness(softness);
        this.setPrice(price);
    }

    public void setSoftness(int softness) {
        this.softness = softness;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //    • softness - int
    //    • price - double
    //        ◦ The price of the toy.

    @Override
    public int getSoftness() {
        return softness;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
