package model.components;

import java.awt.*;

public class RectangleComponent extends DrawingComponent{

    public RectangleComponent(Point position, Dimension dimension) {
        super(position, dimension);
    }

    public RectangleComponent(Point start, Point end) {
        this(new Point(Math.min(start.x, end.x), Math.min(start.y, end.y)), new Dimension(Math.abs(start.x - end.x), Math.abs(start.y - end.y)));
    }
}
