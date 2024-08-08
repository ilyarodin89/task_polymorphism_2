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


        //создается замкнутая кривая
        ClosedPolyLine p1 = new ClosedPolyLine(arrayPoints);

        //расчитывается длина замкнутой кривой
        p1.length();
        System.out.println(p1.length());
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

class Line {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public double getLength() {
        int segment1 = start.x - end.x;
        int segment2 = start.y - end.y;
        return Math.sqrt(segment1 * segment1 + segment2 * segment2);
    }
}


class PolyLine {
    ArrayList<Point> listPoint = new ArrayList<>();

    public PolyLine(ArrayList<Point> listPoint) {
        this.listPoint = listPoint;
    }

    public double length() {
        double sum = 0, len1, len2;
        for (int i = 0; i < listPoint.size() - 1; i++) {
            len1 = listPoint.get(i).x - listPoint.get(i + 1).x;
            len2 = listPoint.get(i).y - listPoint.get(i + 1).y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }
}

class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(ArrayList<Point> listPoint) {
        super(listPoint);
    }

    public double length() {
        return super.length() + new Line(listPoint.get(0), listPoint.get(listPoint.size() - 1)).getLength();
    }

}