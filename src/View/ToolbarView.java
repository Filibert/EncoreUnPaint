package view;

import model.Drawing;
import view.tools.LineToolView;
import view.tools.RectangleToolView;
import view.tools.SelectionToolView;
import view.tools.ToolView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToolbarView{

    private final JToolBar toolBar;

    private final JButton mainColorButton;
    private final JButton secondaryColorButton;

    private final Drawing drawing;

    private final List<ToolView> toolViewList = new ArrayList<>();

    public ToolbarView(Drawing drawing) {
        this.drawing = drawing;

        toolBar = new JToolBar(null, JToolBar.VERTICAL);

        populateToolViewList();

        for(ToolView toolView : toolViewList)
        {
            toolBar.add(toolView);
        }

        /*
        JButton selectButton = toolBar.add(new SelectAction());
        selectButton.setText("select");

        JButton formColoringButton = toolBar.add(new FormColoringAction());
        formColoringButton.setText("formColoring");

        toolBar.addSeparator();

        JButton drawOvalButton = toolBar.add(new FormColoringAction());
        drawOvalButton.setText("ovalButton");

        JButton drawRectangleButton = toolBar.add(new FormColoringAction());
        drawRectangleButton.setText("rectangle");

        JButton drawLineButton = toolBar.add(new FormColoringAction());
        drawLineButton.setText("line");

        */
        toolBar.addSeparator();

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.X_AXIS));

        mainColorButton = new JButton();
        secondaryColorButton = new JButton();

        jpanel.add(mainColorButton);
        jpanel.add(secondaryColorButton);

        toolBar.add(jpanel);
    }

    private void populateToolViewList() {
        toolViewList.add(new SelectionToolView());
        toolViewList.add(new RectangleToolView());
        toolViewList.add(new LineToolView());

    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void update(){
        toolBar.removeAll();
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public List<ToolView> getToolViewList() {
        return toolViewList;
    }

    public JButton getMainColorButton() {
        return mainColorButton;
    }

    public JButton getSecondaryColorButton() {
        return secondaryColorButton;
    }
}
