package view.components;

import model.components.LineComponent;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineView extends DrawingComponentView {

    private LineComponent lineComponent;

    public LineView(LineComponent lineComponent) {
        super(lineComponent);

        this.lineComponent = lineComponent;

        update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(lineComponent.getMainColor());

            if (lineComponent.isSelected()) {
                g2d.setStroke(new BasicStroke(6));
            } else {
                g2d.setStroke(new BasicStroke(3));
            }


            g2d.draw(new Line2D.Float(  lineComponent.getStart().x  - lineComponent.getPosition().x,
                                        lineComponent.getStart().y  - lineComponent.getPosition().y,
                                        lineComponent.getEnd().x    - lineComponent.getPosition().x,
                                        lineComponent.getEnd().y    - lineComponent.getPosition().y));
        }
    }
}
