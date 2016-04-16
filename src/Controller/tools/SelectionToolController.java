package controller.tools;

import view.MainFrame;
import view.components.DrawingComponentView;
import tools.SelectionTool;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class SelectionToolController extends ToolController {

    private Map<DrawingComponentView, MouseListener> listenerMap = new HashMap<>();
    private MouseListener drawingViewListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            getFrame().getDrawingView().getDrawing().setSelection(null);
        }
    };

    public SelectionToolController(MainFrame mainFrame, SelectionTool.SelectionToolView toolView) {
        super(mainFrame, toolView);
    }

    @Override
    public void onSelectTool() {
        for(DrawingComponentView drawingComponentView : getFrame().getDrawingView().getDrawingComponentViewList()){
            MouseListener mouseListener = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    getFrame().getDrawingView().getDrawing().setSelection(drawingComponentView.getDrawingComponent());
                }
            };

            listenerMap.put(drawingComponentView, mouseListener);
            drawingComponentView.addMouseListener(mouseListener);
        }

        getFrame().getDrawingView().getPanel().addMouseListener(drawingViewListener);
    }

    @Override
    public void onDeselectTool() {
        for(Map.Entry<DrawingComponentView, MouseListener> entry : listenerMap.entrySet())
        {
            entry.getKey().removeMouseListener(entry.getValue());
        }

        getFrame().getDrawingView().getPanel().removeMouseListener(drawingViewListener);
    }
}
