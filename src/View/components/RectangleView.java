package view.components;

import model.components.RectangleComponent;

import java.awt.*;

public class RectangleView extends DrawingComponentView{

    RectangleComponent rectangle;

    public RectangleView(RectangleComponent rectangle) {
        super(rectangle);

        this.rectangle = rectangle;
    }

    @Override
    public void update() {
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Point position = rectangle.getPosition();
        Dimension dimension = rectangle.getDimension();

        g.drawRect(position.x,position.y,dimension.width,dimension.height);
        g.setColor(rectangle.getMainColor());
        g.fillRect(position.x,position.y,dimension.width,dimension.height);
    }
}
