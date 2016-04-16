package model.components;

import java.awt.*;

public class LineComponent extends DrawingComponent{

    private Point start;
    private Point end;

    public LineComponent(Point start, Point end) {
        super(new Point(Math.min(start.x, end.x), Math.min(start.y, end.y)), new Dimension(Math.abs(start.x - end.x), Math.abs(start.y - end.y)));

        System.out.println("start " + start + ", end " + end);
        System.out.println(new Point(Math.min(start.x, end.x), Math.min(start.y, end.y)) + "dim : " + new Dimension(Math.abs(start.x - end.x), Math.abs(start.y - end.y)));

        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
