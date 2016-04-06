package View;

import Controller.ToolbarController.FormColoringAction;
import Controller.ToolbarController.SelectAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarView  extends JToolBar{

    private Color selectedColor1;
    private Color selectedColor2;

    public ToolbarView() {
        super(null,JToolBar.VERTICAL);

        JButton selectButton = add(new SelectAction());
        selectButton.setText("select");

        JButton formColoringButton = add(new FormColoringAction());
        formColoringButton.setText("formColoring");

        addSeparator();

        JButton drawOvalButton = add(new FormColoringAction());
        drawOvalButton.setText("ovalButton");

        JButton drawRectangleButton = add(new FormColoringAction());
        drawRectangleButton.setText("rectangle");

        JButton drawLineButton = add(new FormColoringAction());
        drawLineButton.setText("line");

        addSeparator();

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.X_AXIS));

        JButton ColorSelectButton1 = new JButton();
        JButton ColorSelectButton2 = new JButton();

        ColorSelectButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 selectedColor1 = JColorChooser.showDialog(null,"Color",null);
            }
        });
        // lambda expressions ??
        ColorSelectButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 selectedColor2 = JColorChooser.showDialog(null,"Color",null);
            }
        });
        ColorSelectButton1.setBackground(selectedColor1);
        ColorSelectButton2.setBackground(selectedColor2);
        jpanel.add(ColorSelectButton1);
        jpanel.add(ColorSelectButton2);

        add(jpanel);
        // coucou arnau sans d
        // appelle moi au 06 59 12 45 64
        // je suis le père noël
        // j'avoue j'ai menti
        // :'(
    }
}
