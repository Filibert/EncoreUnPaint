package test;

import model.Drawing;
import view.MainFrame;

public class MainFrameTest {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        new MainFrame(drawing);
    }
}
