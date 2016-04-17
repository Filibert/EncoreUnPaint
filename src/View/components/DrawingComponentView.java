package view.components;


import model.components.DrawingComponent;

import javax.swing.*;

public abstract class DrawingComponentView extends JPanel {

    private final DrawingComponent drawingComponent;

    public DrawingComponentView(DrawingComponent drawingComponent) {
        this.drawingComponent = drawingComponent;

        setLayout(null);
        setOpaque(false);
    }

    public DrawingComponent getDrawingComponent() {
        return drawingComponent;
    }

    public void update(){
        updateSize();

        repaint();
        revalidate();
    }

    private void updateSize() {
        setBounds(drawingComponent.getPosition().x, drawingComponent.getPosition().y, drawingComponent.getDimension().width, drawingComponent.getDimension().height);
    }
}
