package tools;

import javax.swing.*;

public abstract class ToolView extends JButton {
    private String helpText;

    public ToolView(String text) {
        super(text);
    }

    abstract  public String getHelpText();
}
