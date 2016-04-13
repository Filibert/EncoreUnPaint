package view.components;


import model.components.DrawingComponent;

public abstract class DrawingComponentView {

    private final DrawingComponent drawingComponent;

    public DrawingComponentView(DrawingComponent drawingComponent) {
        this.drawingComponent = drawingComponent;
    }

    public DrawingComponent getDrawingComponent() {
        return drawingComponent;
    }
}
