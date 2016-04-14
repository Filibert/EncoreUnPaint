package view.components;


import model.components.DrawingComponent;

import javax.swing.*;

public abstract class DrawingComponentView extends JPanel {

    private final DrawingComponent drawingComponent;

    public DrawingComponentView(DrawingComponent drawingComponent) {
        this.drawingComponent = drawingComponent;
    }

    public DrawingComponent getDrawingComponent() {
        return drawingComponent;
    }

    public abstract void update();
}
