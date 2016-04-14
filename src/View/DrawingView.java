package view;

import model.Drawing;
import view.components.DrawingComponentView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingView {

    private final JPanel panel = new JPanel();

    private final Drawing drawing;
    private final List<DrawingComponentView> drawingComponentViewList = new ArrayList<>();

    public DrawingView(Drawing drawing) {
        this.drawing = drawing;

        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension size = new Dimension(800,800);

        panel.setPreferredSize(size);
        panel.setBackground(Color.white);
    }

    public JPanel getPanel() {
        return panel;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void update() {
        panel.revalidate();
        panel.repaint();
    }

    public List<DrawingComponentView> getDrawingComponentViewList() {
        return drawingComponentViewList;
    }
}
