package controller;

import view.ToolbarView;

import javax.tools.Tool;
import java.util.List;

public class ToolbarController {
    private ToolbarView toolbarView;

    private List<Tool> toolList;

    public ToolbarController(ToolbarView toolbarView) {
        this.toolbarView = toolbarView;
    }

    public ToolbarView getToolbarView() {
        return toolbarView;
    }

    public void setToolbarView(ToolbarView toolbarView) {
        this.toolbarView = toolbarView;
    }
}
