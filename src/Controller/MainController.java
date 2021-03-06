package controller;

import view.MainFrame;

public class MainController {
    private MainFrame mainFrame;

    public MainController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        new DrawingController(mainFrame.getDrawingView());
        new ToolbarController(mainFrame, mainFrame.getToolbarView());
        new FooterController(mainFrame.getFooterView());
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
