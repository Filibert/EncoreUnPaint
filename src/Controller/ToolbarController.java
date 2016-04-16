package controller;

import controller.tools.SelectionToolController;
import controller.tools.ToolController;
import view.MainFrame;
import view.ToolbarView;
import view.tools.SelectionToolView;
import view.tools.ToolView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class ToolbarController {
    private final MainFrame mainFrame;
    private final ToolbarView toolbarView;

    private Map<ToolView, ToolController> toolControllerMap = new HashMap<>();
    private ToolController activeToolController = null;

    public ToolbarController(MainFrame mainFrame, ToolbarView toolbarView) {
        this.mainFrame = mainFrame;
        this.toolbarView = toolbarView;

        populateToolControllerList();

        for(Map.Entry<ToolView, ToolController> entry : toolControllerMap.entrySet())
        {
            entry.getKey().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setActiveToolController(entry.getValue());
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
    }

    private void populateToolControllerList() {
        for(ToolView toolView : toolbarView.getToolViewList())
        {
            if(toolView instanceof SelectionToolView)
                toolControllerMap.put(toolView, new SelectionToolController(mainFrame, (SelectionToolView) toolView));
        }
    }

    public ToolbarView getToolbarView() {
        return toolbarView;
    }

    public void setActiveToolController(ToolController activeToolController) {
        if(activeToolController != null)
            activeToolController.onDeselectTool();

        this.activeToolController = activeToolController;

        activeToolController.onSelectTool();
    }
}
