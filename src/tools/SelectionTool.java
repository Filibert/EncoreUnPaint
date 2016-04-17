package tools;


import view.MainFrame;
import view.components.DrawingComponentView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class SelectionTool{
    public class SelectionToolController  {

    }
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


}