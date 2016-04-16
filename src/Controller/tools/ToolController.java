package controller.tools;

import view.MainFrame;
import tools.ToolView;

public abstract class ToolController{

    private final ToolView toolView;
    private final MainFrame frame;

    public ToolController(MainFrame frame, ToolView toolView) {
        this.toolView = toolView;
        this.frame = frame;
    }

    abstract public void onSelectTool();
    abstract public void onDeselectTool();

    public ToolView getToolView() {
        return toolView;
    }

    public MainFrame getFrame() {
        return frame;
    }
}
