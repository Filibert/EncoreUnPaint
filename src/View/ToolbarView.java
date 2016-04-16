package view;

import model.Drawing;
import tools.ToolView;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToolbarView{

    private final JToolBar toolBar;

    private Color mainColor;
    private Color secondaryColor;

    private final Drawing drawing;

    private final List<ToolView> toolViewList = new ArrayList<>();
    private final ToolView activeTool = null;

    public ToolbarView(Drawing drawing) {
        this.drawing = drawing;

        toolBar = new JToolBar(null, JToolBar.VERTICAL);

        populateToolViewList();

        for(ToolView toolView : toolViewList)
        {
            toolBar.add(toolView);
        }

        toolBar.addSeparator();

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.X_AXIS));

        JButton ColorSelectButton1 = new JButton();
        JButton ColorSelectButton2 = new JButton();

      /*  ColorSelectButton1.addActionListener(e -> mainColor = JColorChooser.showDialog(null,"Color",null));

        ColorSelectButton2.addActionListener(e -> secondaryColor = JColorChooser.showDialog(null,"Color",null));
        ColorSelectButton1.setBackground(mainColor);
        ColorSelectButton2.setBackground(secondaryColor);
        jpanel.add(ColorSelectButton1);
        jpanel.add(ColorSelectButton2);

        toolBar.add(jpanel);*/
    }

    private void populateToolViewList() {
        File toolsFolder = new File(ToolbarView.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/tools/");
        File[] fileList = toolsFolder.listFiles();
        String extension , nameWithExtension , nameWithoutExtension , outerClassName = "";

        Object object;
        for(File file : fileList){
            boolean isView = false;
            nameWithExtension = file.getName();
            extension = nameWithExtension.substring(nameWithExtension.lastIndexOf("."));
            nameWithoutExtension = nameWithExtension.substring(0,nameWithExtension.lastIndexOf("."));
            if (nameWithExtension.contains("$")){
                outerClassName = nameWithoutExtension.substring(0,nameWithoutExtension.lastIndexOf("$"));
                if(nameWithoutExtension.endsWith("View")){
                    isView = true;
                }
            }
            if("ToolView".equals(nameWithoutExtension)|| !isView )
                continue;

            if(file.isFile() && ".class".equals(extension)){
                String outerClassNameWithPackage = "tools." + outerClassName;
                String innerClassNameWithPackage = "tools." + nameWithoutExtension;
                try {
                    Class<?> tool = Class.forName(outerClassNameWithPackage);
                    Object o = tool.newInstance();

                    Class<?> toolView = Class.forName(innerClassNameWithPackage);
                    Constructor<?> ctor = toolView.getDeclaredConstructor(tool);
                    Object button =  ctor.newInstance(o);
                    toolViewList.add((ToolView) button);
                } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException e){
                    e.printStackTrace();
                }


            }

        }
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void update(){
        toolBar.removeAll();
    }

    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public List<ToolView> getToolViewList() {
        return toolViewList;
    }
}
