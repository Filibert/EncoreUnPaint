package view;

import controller.toolbar.FormColoringAction;
import controller.toolbar.SelectAction;
import model.Drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarView{

    private final JToolBar toolBar;

    private Color selectedColor1;
    private Color selectedColor2;

    private final Drawing drawing;


    public ToolbarView(Drawing drawing) {
        this.drawing = drawing;

        toolBar = new JToolBar(null, JToolBar.VERTICAL);

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

        toolBar.addSeparator();

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.X_AXIS));

        JButton ColorSelectButton1 = new JButton();
        JButton ColorSelectButton2 = new JButton();

        ColorSelectButton1.addActionListener(e -> selectedColor1 = JColorChooser.showDialog(null,"Color",null));

        ColorSelectButton2.addActionListener(e -> selectedColor2 = JColorChooser.showDialog(null,"Color",null));
        ColorSelectButton1.setBackground(selectedColor1);
        ColorSelectButton2.setBackground(selectedColor2);
        jpanel.add(ColorSelectButton1);
        jpanel.add(ColorSelectButton2);

        toolBar.add(jpanel);
        // coucou arnau sans d
        // appelle moi au 06 59 12 45 64
        // je suis le père noël
        // j'avoue j'ai menti
        // :'(
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public Color getSelectedColor1() {
        return selectedColor1;
    }

    public void setSelectedColor1(Color selectedColor1) {
        this.selectedColor1 = selectedColor1;
    }

    public Color getSelectedColor2() {
        return selectedColor2;
    }

    public void setSelectedColor2(Color selectedColor2) {
        this.selectedColor2 = selectedColor2;
    }
}
