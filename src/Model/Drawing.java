package model;

import model.components.DrawingComponent;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

    private List<DrawingListener> drawingListenerList = new ArrayList<>();
    private List<DrawingComponent> drawingComponentList = new ArrayList<>();

    private DrawingComponent selection = null;

    public List<DrawingComponent> getDrawingComponentList() {
        return drawingComponentList;
    }

    public void addDrawingComponent(DrawingComponent drawingComponent){
        drawingComponent.setDrawing(this);

        drawingComponentList.add(drawingComponent);
        fireDrawingModified();
    }

    public void removeDrawingComponent(DrawingComponent drawingComponent)
    {
        boolean removed = drawingComponentList.remove(drawingComponent);

        drawingComponent.setDrawing(null);

        if(removed)
            fireDrawingModified();
    }

    private void fireDrawingModified() {
        drawingListenerList.forEach(DrawingListener::onDrawingChanged);
    }

    public void addDrawingListener(DrawingListener drawingListener) {
        drawingListenerList.add(drawingListener);
    }

    public void removeDrawingListener(DrawingListener drawingListener){
        drawingListenerList.remove(drawingListener);
    }

    public DrawingComponent getSelection() {
        return selection;
    }

    public void setSelection(DrawingComponent selection) {
        this.selection = selection;

        fireDrawingModified();
    }

}
