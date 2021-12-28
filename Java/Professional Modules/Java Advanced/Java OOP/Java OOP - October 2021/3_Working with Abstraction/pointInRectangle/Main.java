package pointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//        Point point = new Point(0, 0);
//        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(3, 3));
//
//        System.out.println(rectangle.contains(point));


        String[] rectangleInfo = scan.nextLine().split("\\s+");

        int a = Integer.parseInt(rectangleInfo[0]);
        int b = Integer.parseInt(rectangleInfo[1]);
        int c = Integer.parseInt(rectangleInfo[2]);
        int d = Integer.parseInt(rectangleInfo[3]);

        Point bottomLeft = new Point(a, b);
        Point topRight = new Point(c, d);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);

            Point point = new Point(x, y);

            System.out.println(rectangle.contains(point));
        }

    }
}
