package view.components;

import model.components.RectangleComponent;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleView extends DrawingComponentView{

    RectangleComponent rectangle;

    public RectangleView(RectangleComponent rectangle) {
        super(rectangle);

        this.rectangle = rectangle;

        update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(g instanceof Graphics2D){

            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(rectangle.getMainColor());

            if(rectangle.isSelected()){
                g2d.setStroke(new BasicStroke(10));
            } else {
                g2d.setStroke(new BasicStroke(3));
            }

            g2d.fill(new Rectangle2D.Float(0,0, rectangle.getDimension().width - 1, rectangle.getDimension().height - 1));
            g2d.setPaint(rectangle.getSecondaryColor());
            g2d.draw(new Rectangle2D.Float(0,0,rectangle.getDimension().width - 2, rectangle.getDimension().height - 2));
        }
    }
}