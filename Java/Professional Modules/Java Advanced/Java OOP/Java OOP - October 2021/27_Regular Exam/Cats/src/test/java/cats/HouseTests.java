package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {

    House validHouse;

    @Before
    public void setUp() {
        this.validHouse = new House("Valid House", 5);
    }

    @Test(expected = NullPointerException.class)
    public void nameIsNull() {
        House house = new House(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void nameIsWhitespace() {
        House house = new House("   ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void capacityIsLessThanZero() {
        House house = new House("CatsHouse", -4);
    }

    @Test
    public void getCountShouldReturnCorrectCatsCount() {
        Cat cat = new Cat("Kitty");
        validHouse.addCat(cat);
        assertEquals(1, validHouse.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingCatToFullHouse() {
        House house = new House("Home", 0);
        Cat cat = new Cat("Kitty");
        house.addCat(cat);
    }

    @Test
    public void successfullyAddedCat() {
        Cat cat = new Cat("Kitty");
        validHouse.addCat(cat);
        assertEquals(1, validHouse.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removingNonExistingCat() {
        validHouse.removeCat("Kitty");
    }

    @Test
    public void successfullyRemovedCat() {
        Cat cat = new Cat("Kitty");
        validHouse.addCat(cat);
        validHouse.removeCat("Kitty");
        assertEquals(0, validHouse.getCount());
    }

    @Test
    public void statisticsShouldReturnCorrectMessage() {
        Cat cat = new Cat("Kitty");
        Cat cat1 = new Cat("Miaui");
        validHouse.addCat(cat);
        validHouse.addCat(cat1);
        String actual = validHouse.statistics();
        String expected = "The cat Kitty, Miaui is in the house Valid House!";

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellingNonExistingCat() {
        Cat cat = validHouse.catForSale("Kitty");
    }

    @Test
    public void successfullySoldCat() {
        Cat cat = new Cat("Kitty");
        validHouse.addCat(cat);
        Cat forSale = validHouse.catForSale("Kitty");

        assertFalse(forSale.isHungry());
    }
}
