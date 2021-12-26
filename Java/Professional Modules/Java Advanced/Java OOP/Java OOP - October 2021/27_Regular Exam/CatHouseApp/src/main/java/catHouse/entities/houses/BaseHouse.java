package catHouse.entities.houses;

import catHouse.entities.cat.BaseCat;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //    • name - String
    //        ◦ If the name is null or whitespace, throw a NullPointerException with a message:
    //"House name cannot be null or empty."
    //        ◦ All names are unique.
    //    • capacity -  int
    //        ◦ The number of Cat аn House can have.
    //    • toys - Collection<Toy>
    //    • cats - Collection<Cat>

//    public double catsPrice() {
//        double value = 0;
//        for (Cat cat : cats) {
//            value += cat.getPrice();
//        }
//        return value;
//    }
//
//    public double toysPrice() {
//        double value = 0;
//        for (Toy toy : toys) {
//            value += toy.getPrice();
//        }
//        return value;
//    }

    @Override
    public int sumSoftness() {
        int softnessSum = 0;
        for (Toy toy : toys) {
            softnessSum += toy.getSoftness();
        }
        return softnessSum;
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= cats.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
        //Adds a Cat in the House if there is a capacity for it.
        //If there is not enough capacity to add the Cat in the House,
        // throw an IllegalStateException with the following message:
        //    • "Not enough capacity for this cat."
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%s %s:%n", this.getName(), this.getClass().getSimpleName()));
        str.append(String.format("Cats: "));

        StringBuilder cats = new StringBuilder();
        for (Cat cat : this.cats) {
            cats.append(String.format("%s ", cat.getName()));
        }

        if (this.cats.isEmpty()) {
            str.append(String.format("none%n"));
        } else {
            str.append(cats.toString().trim());
            str.append(System.lineSeparator());
        }

        str.append(String.format("Toys: %d Softness: %d", toys.size(), this.sumSoftness()));

        return str.toString().trim();

        //Returns a String with information about the House in the format below.
        //If the House doesn't have a cat, print "none" instead.
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }


}
