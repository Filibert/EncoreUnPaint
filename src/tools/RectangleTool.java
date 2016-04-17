package tools;

import model.components.RectangleComponent;
import view.MainFrame;
import view.tools.RectangleToolView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by arnau on 17/04/2016.
 */
public class RectangleTool {
    public class RectangleToolController extends ToolController {

        private Point start;
        private Point end;

        private MouseListener drawingListener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                start = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (start == null) return;

                end = e.getPoint();

                RectangleComponent rectangleComponent = new RectangleComponent(start, end);
                rectangleComponent.setMainColor(getFrame().getDrawingView().getDrawing().getMainColorSelected());
                rectangleComponent.setSecondaryColor(getFrame().getDrawingView().getDrawing().getSecondaryColorSelected());

                getFrame().getDrawingView().getDrawing().addDrawingComponent(rectangleComponent);

                start = null;
                end = null;
            }
        };

        public RectangleToolController(MainFrame frame, RectangleToolView toolView) {
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
    }

    public class RectangleToolView extends ToolView {

        private final static String buttonTitle = "Rectangle";

        public RectangleToolView() {
            super(buttonTitle);
        }

        @Override
        public String getHelpText() {
            return "Draw rectangle";
        }
    }
}
