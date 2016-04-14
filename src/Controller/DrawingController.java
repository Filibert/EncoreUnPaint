package controller;

import controller.components.ComponentController;
import controller.tools.ToolController;
import model.DrawingListener;
import model.components.DrawingComponent;
import model.components.RectangleComponent;
import view.DrawingView;
import view.components.DrawingComponentView;
import view.components.RectangleView;

import javax.swing.text.ComponentView;
import java.util.List;

public class DrawingController implements DrawingListener {
    private DrawingView drawingView;

    public DrawingController(DrawingView drawingView) {
        this.drawingView = drawingView;

        drawingView.getDrawing().addDrawingListener(this);

        updateView();
    }

    public DrawingView getDrawingView() {
        return drawingView;
    }

    public void setDrawingView(DrawingView drawingView) {
        this.drawingView = drawingView;
    }

    @Override
    public void onDrawingChanged() {
        updateView();
    }

    private void updateView() {
        updateComponents();

        drawingView.update();
    }

    private void updateComponents() {

        if(drawingView.getDrawingComponentViewList().size() == drawingView.getDrawing().getDrawingComponentList().size())
            return;

        for(DrawingComponent drawingComponent : drawingView.getDrawing().getDrawingComponentList())
        {
            if(drawingComponent instanceof RectangleComponent)
            {
                RectangleView rectangleView = new RectangleView((RectangleComponent) drawingComponent);
                new ComponentController(rectangleView);

                drawingView.getDrawingComponentViewList().add(rectangleView);
            }
            // TODO : Create drawing component view by type
        }
    }
}
