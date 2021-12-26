package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ExceptionMessages.*;
import static catHouse.common.ConstantMessages.*;

public class ControllerImpl implements Controller{
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);

        //Creates and adds a House to the houses’ collection. Valid types are: "ShortHouse" and "LongHouse".
        //If the House type is invalid, you have to throw a NullPointerException with the following message:
        //    • "Invalid house type."
        //If the House is added successfully, the method should return the following String:
        //    • "{houseType} is successfully added."
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);

        //Creates a toy of the given type and adds it to the ToyRepository.
        //  Valid types are: "Ball" and "Mouse".
        //  If the toy type is invalid, throw an IllegalArgumentException with a message:
        //    • "Invalid toy type."
        //The method should return the following string if the operation is successful:
        //    • "{toyType} is successfully added."
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy byType = toys.findFirst(toyType);
        if (byType == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(byType);
                break;
            }
        }
        toys.removeToy(byType);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);

        //Adds (buys) the desired Toy to the House with the given name.
        // You have to remove the Toy from the ToyRepository if the insert is successful.
        //
        // If there is no such toy, you have to throw an IllegalArgumentException with the following message:
        //    • "Toy of type {toyType} is missing."
        //If no exceptions are thrown, return the String:
        //    • "Successfully added {toyType} to {houseName}."
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        String houseType = "";
        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                houseType = house.getClass().getSimpleName();
            }
        }

        if ((houseType.equals("ShortHouse") && catType.equals("LonghairCat"))
                || (houseType.equals("LongHouse") && catType.equals("ShorthairCat"))) {
            return UNSUITABLE_HOUSE;
        }

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.addCat(cat);
                break;
            }
        }
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);

        //Creates and adds the desired Cat to the House with the given name.
        //  Valid Cat types are: "ShorthairCat", "LonghairCat".
        //
        // Note: The method must first check whether the cat type is valid.
        //
        // If the Cat type is invalid, you have to throw an IllegalArgumentException with the following message:
        //    • "Invalid cat type."
        //If no errors are thrown, return one of the following strings:
        //    • "Unsuitable house." - if the given Cat cannot live in the House.
        //    • "Successfully added {catType} to {houseName}." - if the Cat is added successfully in the House.
    }

    @Override
    public String feedingCat(String houseName) {
        int fedCatsCount = 0;

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.feeding();
                fedCatsCount = house.getCats().size();
                break;
            }
        }

        return String.format(FEEDING_CAT, fedCatsCount);

        //Feeds all Cat in the House with the given name.
        //Returns a string with information about how many cats were successfully fed, in the following format:
        //    • "Feeding a cat: {fedCount}"
    }

    @Override
    public String sumOfAll(String houseName) {
        double value = 0;

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                for (Cat cat : house.getCats()) {
                    value += cat.getPrice();
                }
                for (Toy toy : house.getToys()) {
                    value += toy.getPrice();
                }
                break;
            }
        }
        return String.format(VALUE_HOUSE, houseName, value);

        //Calculates the value of the House with the given name.
        // It is calculated by the sum of all Cat’s and Toy’s prices in the House.
        //Return a string in the following format:
        //    • "The value of House {houseName} is {value}."
        //        ◦ The value should be formatted to the 2nd decimal place!
    }

    @Override
    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        for (House house : houses) {
            str.append(house.getStatistics());
            str.append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
