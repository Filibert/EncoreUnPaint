package view.tools;

public class LineToolView extends ToolView {

    private final static String buttonTitle = "Line";

    public LineToolView() {
        super(buttonTitle);
    }

    @Override
    public String getHelpText() {
        return "Draw line";
    }
}
