package cats;

public class Main {
    public static void main(String[] args) {

        House validHouse = new House("ValidHouse", 5);

        Cat cat = new Cat("Kitty");
        Cat cat1 = new Cat("Miaui");
        validHouse.addCat(cat);
        validHouse.addCat(cat1);

        System.out.println(validHouse.statistics());
    }
}
