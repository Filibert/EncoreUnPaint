package test;

import controller.MainController;
import model.Drawing;
import model.components.LineComponent;
import model.components.RectangleComponent;
import view.MainFrame;

import java.awt.*;

public class MainFrameTest {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();

        RectangleComponent rectangleComponent = new RectangleComponent(new Point(20, 20), new Dimension(500, 500));
        rectangleComponent.setMainColor(Color.BLUE);
        rectangleComponent.setSecondaryColor(Color.CYAN);

        LineComponent lineComponent = new LineComponent(new Point(10, 10), new Point(25, 30));

        lineComponent.setMainColor(Color.MAGENTA);

        //drawing.addDrawingComponent(rectangleComponent);
        drawing.addDrawingComponent(lineComponent);

        MainFrame mainFrame = new MainFrame(drawing);
        new MainController(mainFrame);
    }
}
