package model.components;


import model.Drawing;

import java.awt.*;

public abstract class DrawingComponent {
    private Drawing drawing;

    private Point position;
    private Dimension dimension;

    private Color mainColor;
    private Color secondaryColor;

    public DrawingComponent(Point position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    public boolean isSelected()
    {
        if(drawing == null)
            return false;

        if(drawing.getSelection() == this)
            return true;
        else
            return false;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Drawing Component : position : " + position + ", dimension : " + dimension;
    }
}
