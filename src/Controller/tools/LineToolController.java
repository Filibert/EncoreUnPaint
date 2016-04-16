package controller.tools;

import model.components.LineComponent;
import model.components.RectangleComponent;
import view.MainFrame;
import view.tools.LineToolView;
import view.tools.RectangleToolView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LineToolController extends ToolController{

    private Point start;
    private Point end;

    private MouseListener drawingListener = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {
            start = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(start == null) return;

            end = e.getPoint();

            LineComponent lineComponent = new LineComponent(start, end);
            lineComponent.setMainColor(getFrame().getDrawingView().getDrawing().getMainColorSelected());
            lineComponent.setSecondaryColor(getFrame().getDrawingView().getDrawing().getSecondaryColorSelected());

            getFrame().getDrawingView().getDrawing().addDrawingComponent(lineComponent);

            start = null;
            end = null;
        }
    };

    public LineToolController(MainFrame frame, LineToolView toolView) {
        super(frame, toolView);
    }

    @Override
    public void onSelectTool() {
        getFrame().getDrawingView().getPanel().addMouseListener(drawingListener);
    }

    @Override
    public void onDeselectTool() {
        getFrame().getDrawingView().getPanel().removeMouseListener(drawingListener);
    }


    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
