package controller;

import controller.tools.SelectionToolController;
import controller.tools.ToolController;
import view.MainFrame;
import view.ToolbarView;
import tools.SelectionTool;
import tools.ToolView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
            entry.getKey().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setActiveToolController(entry.getValue());
                }
            });
        }
    }

    private void populateToolControllerList() {
        for(ToolView toolView : toolbarView.getToolViewList())
        {
            if(toolView instanceof SelectionTool.SelectionToolView)
                toolControllerMap.put(toolView, new SelectionToolController(mainFrame, (SelectionTool.SelectionToolView) toolView));
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
