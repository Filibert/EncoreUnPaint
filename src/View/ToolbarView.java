package view;

import controller.toolbar.FormColoringAction;
import controller.toolbar.SelectAction;
import model.Drawing;
import view.components.RectangleView;
import view.tools.SelectionToolView;
import view.tools.ToolView;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToolbarView{

    private final JToolBar toolBar;

    private Color mainColor;
    private Color secondaryColor;

    private final Drawing drawing;

    private final List<ToolView> toolViewList = new ArrayList<>();
    private final ToolView activeTool = null;

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

        JButton ColorSelectButton1 = new JButton();
        JButton ColorSelectButton2 = new JButton();

        ColorSelectButton1.addActionListener(e -> mainColor = JColorChooser.showDialog(null,"Color",null));

        ColorSelectButton2.addActionListener(e -> secondaryColor = JColorChooser.showDialog(null,"Color",null));
        ColorSelectButton1.setBackground(mainColor);
        ColorSelectButton2.setBackground(secondaryColor);
        jpanel.add(ColorSelectButton1);
        jpanel.add(ColorSelectButton2);

        toolBar.add(jpanel);
    }

    private void populateToolViewList() {
        toolViewList.add(new SelectionToolView());
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void update(){
        toolBar.removeAll();
    }

    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public List<ToolView> getToolViewList() {
        return toolViewList;
    }
}
