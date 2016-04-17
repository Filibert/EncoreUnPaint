package view.tools;

import tools.ToolView;

public class RectangleToolView extends ToolView {

    private final static String buttonTitle = "Rectangle";

    public RectangleToolView() {
        super(buttonTitle);
    }

    @Override
    public String getHelpText() {
        return "Draw rectangle";
    }
}
