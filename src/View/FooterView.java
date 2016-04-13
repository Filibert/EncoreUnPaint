package view;

import model.Drawing;
import model.DrawingListener;

import javax.swing.*;

public class FooterView implements DrawingListener{
    private final JPanel panel = new JPanel();

    private final Drawing drawing;

    public FooterView(Drawing drawing) {
        this.drawing = drawing;

        drawing.addDrawingListener(this);
    }

    public JPanel getPanel() {
        return panel;
    }


    @Override
    public void onDrawingChanged() {

    }
}
