package view;

import javax.swing.*;
import java.awt.*;

public class DrawingContainerView extends JPanel {
    public DrawingContainerView() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = new Dimension(800,800);
        setPreferredSize(size);
        setBackground(Color.white);

    }
}
