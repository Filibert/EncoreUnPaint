package view;

import model.Drawing;
import model.DrawingListener;

import javax.swing.*;
import java.awt.*;

public class FooterView{
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();

    private final Drawing drawing;

    public FooterView(Drawing drawing) {
        this.drawing = drawing;
        panel.add(label);
        panel.setPreferredSize(new Dimension(100, 20));
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabel() {
        return label;
    }

    public Drawing getDrawing() {
        return drawing;
    }
}
