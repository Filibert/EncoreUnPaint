package model.components;

import java.awt.*;

public class RectangleComponent extends DrawingComponent{
    private Dimension dimension;

    public RectangleComponent(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
