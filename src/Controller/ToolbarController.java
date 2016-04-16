package controller;

import controller.tools.LineToolController;
import controller.tools.RectangleToolController;
import controller.tools.SelectionToolController;
import controller.tools.ToolController;
import view.MainFrame;
import view.ToolbarView;
import view.tools.LineToolView;
import view.tools.RectangleToolView;
import view.tools.SelectionToolView;
import view.tools.ToolView;

import javax.swing.*;
import java.awt.*;
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
                public void mousePressed(MouseEvent e) {
                    setActiveToolController(entry.getValue());
                }
            });
        }
        
        handleColorSelect();
    }

    private void handleColorSelect() {

        toolbarView.getMainColorButton().addActionListener(e -> {
            Color mainColor = JColorChooser.showDialog(null,"Main color",null);
            toolbarView.getMainColorButton().setBackground(mainColor);
            mainFrame.getDrawingView().getDrawing().setMainColorSelected(mainColor);
        });

        toolbarView.getSecondaryColorButton().addActionListener(e -> {
            Color secondaryColor = JColorChooser.showDialog(null,"Secondary Color",null);
            toolbarView.getMainColorButton().setBackground(secondaryColor);
            mainFrame.getDrawingView().getDrawing().setSecondaryColorSelected(secondaryColor);
        });

        toolbarView.getMainColorButton().setBackground(mainFrame.getDrawingView().getDrawing().getMainColorSelected());
        toolbarView.getSecondaryColorButton().setBackground(mainFrame.getDrawingView().getDrawing().getSecondaryColorSelected());

    }

    private void populateToolControllerList() {
        for(ToolView toolView : toolbarView.getToolViewList())
        {
            if(toolView instanceof SelectionToolView)
                toolControllerMap.put(toolView, new SelectionToolController(mainFrame, (SelectionToolView) toolView));

            if(toolView instanceof RectangleToolView)
                toolControllerMap.put(toolView, new RectangleToolController(mainFrame, (RectangleToolView) toolView));

            if(toolView instanceof LineToolView)
                toolControllerMap.put(toolView, new LineToolController(mainFrame, (LineToolView) toolView));
        }
    }

    public ToolbarView getToolbarView() {
        return toolbarView;
    }

    private void setActiveToolController(ToolController activeToolController) {

        if (this.activeToolController != null) {
            this.activeToolController.onDeselectTool();
        }

        this.activeToolController = activeToolController;

        if(activeToolController != null)
            activeToolController.onSelectTool();

    }
}
