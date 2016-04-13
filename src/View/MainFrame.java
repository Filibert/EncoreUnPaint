package view;

import model.Drawing;

import javax.swing.*;
import java.awt.*;

public class MainFrame{

    private final JFrame frame = new JFrame();

    private final ToolbarView toolbarView;
    private final FooterView footerView;
    private final DrawingView drawingContainer;

    public MainFrame(Drawing drawing) {
        toolbarView = new ToolbarView(drawing);
        drawingContainer = new DrawingView(drawing);
        footerView = new FooterView(drawing);

        frame.setSize(new Dimension(800,600));

        JPanel nullLayoutArea = new JPanel();
        nullLayoutArea.setLayout(new FlowLayout());
        nullLayoutArea.add(drawingContainer.getPanel());

        JScrollPane drawingContainerScrollPane = new JScrollPane(nullLayoutArea);

        frame.add(drawingContainerScrollPane, BorderLayout.CENTER);
        frame.add(footerView.getPanel(), BorderLayout.SOUTH);
        frame.add(toolbarView.getToolBar(), BorderLayout.WEST);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }

    public ToolbarView getToolbarView() {
        return toolbarView;
    }

    public DrawingView getDrawingContainer() {
        return drawingContainer;
    }

    public FooterView getFooterView() {
        return footerView;
    }
}
