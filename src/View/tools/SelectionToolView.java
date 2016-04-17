package view.tools;

import tools.ToolView;

public class SelectionToolView extends ToolView {

    private final static String buttonText = "Select";

    public SelectionToolView() {
        super(buttonText);
    }

    @Override
    public String getHelpText() {
        return "Select component";
    }
}
