package controller.components;

import view.components.DrawingComponentView;

public class ComponentController {
    private final DrawingComponentView drawingComponentView;

    public ComponentController(DrawingComponentView drawingComponentView) {
        this.drawingComponentView = drawingComponentView;
    }

    public DrawingComponentView getDrawingComponentView() {
        return drawingComponentView;
    }
}
