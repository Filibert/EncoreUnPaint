package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private ToolbarView toolbarView = new ToolbarView();
    private DrawingContainerView drawingContainer = new DrawingContainerView();
    private FooterView footerView = new FooterView();

    public MainFrame() throws HeadlessException {

        setSize(new Dimension(800,600));


        JPanel nullLayoutArea = new JPanel();
        nullLayoutArea.setLayout(new FlowLayout());
        nullLayoutArea.add(drawingContainer);

        JScrollPane drawingContainerScrollPane = new JScrollPane(nullLayoutArea);

        add(drawingContainerScrollPane,BorderLayout.CENTER);
        add(footerView,BorderLayout.SOUTH);
        add(toolbarView,BorderLayout.WEST);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
