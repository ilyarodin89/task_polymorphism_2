import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(2, 8);
        Point point3 = new Point(5, 3);
        Point point4 = new Point(8, 9);

        //Создается массив точек для создания ломаной линии
        ArrayList<Point> arrayPoints = new ArrayList<>();
        arrayPoints.add(point1);
        arrayPoints.add(point2);
        arrayPoints.add(point3);
        arrayPoints.add(point4);
        arrayPoints.add(point1);

        //создается замкнутая кривая
        ClosedPolyLine p1 = new ClosedPolyLine(arrayPoints);
        //расчитывается длина замкнутой кривой
        p1.getLength(arrayPoints);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

class PolyLine {
    ArrayList<Point> listPoint = new ArrayList<>();

    //конструктор с массивом точек
    public PolyLine(ArrayList<Point> listPoint) {
        this.listPoint = listPoint;
    }

    //расчитать длину ломаной
    public double getLength(ArrayList<Point> listPoint) {
        this.listPoint = listPoint;
        double polyLineLength = 0;
        for (int i = 0; i < listPoint.size()-1; i++) {
            int katet1 = listPoint.get(i + 1).x - listPoint.get(i).x;
            int katet2 = listPoint.get(i + 1).y - listPoint.get(i).y;
            double segment = Math.sqrt(katet1 * katet1 + katet2 * katet2);
            polyLineLength += segment;
        }
        System.out.println("Общая длина ломаной " + polyLineLength);
        return polyLineLength;
    }

    public String toString() {
        return "Линия " + listPoint.toString();
    }
}

class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(ArrayList<Point> listPoint) {
        super(listPoint);
    }
}