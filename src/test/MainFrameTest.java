package test;

import controller.MainController;
import model.Drawing;
import view.MainFrame;

public class MainFrameTest {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        MainFrame mainFrame = new MainFrame(drawing);
        new MainController(mainFrame);
    }
}
