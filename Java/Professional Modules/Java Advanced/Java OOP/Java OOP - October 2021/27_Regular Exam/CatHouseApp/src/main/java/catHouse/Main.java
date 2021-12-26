package catHouse;

import catHouse.core.Engine;
import catHouse.core.EngineImpl;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();

    }
}
