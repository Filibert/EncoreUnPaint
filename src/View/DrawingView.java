package view;

import model.Drawing;
import model.DrawingListener;

import javax.swing.*;
import java.awt.*;

public class DrawingView implements DrawingListener {

    private final JPanel panel = new JPanel();

    private final Drawing drawing;

    public DrawingView(Drawing drawing) {
        this.drawing = drawing;

        drawing.addDrawingListener(this);

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

    @Override
    public void onDrawingChanged() {
        update();
    }

    private void update() {
        panel.revalidate();
        panel.repaint();
    }
}
