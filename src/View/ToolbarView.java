package view;

import model.Drawing;
import tools.ToolView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ToolbarView{

    private final JToolBar toolBar;

    private final JButton mainColorButton;
    private final JButton secondaryColorButton;
    private Color mainColor,secondaryColor;

    private final Drawing drawing;

    private final List<ToolView> toolViewList = new ArrayList<>();

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

        mainColorButton = new JButton();
        secondaryColorButton = new JButton();
        JButton plus = new JButton("+");
        toolBar.add(plus);
        //toolBar.setButtonSize(plus,25,25);

        JButton minus = new JButton("-");
        toolBar.add(minus);
       // toolBar.setButtonSize(minus,25,25);
        mainColorButton.addActionListener(e -> mainColor = JColorChooser.showDialog(null,"Color",null));
        secondaryColorButton.addActionListener(e -> secondaryColor = JColorChooser.showDialog(null,"Color",null));
        mainColorButton.setBackground(mainColor);
        secondaryColorButton.setBackground(secondaryColor);
        jpanel.add(mainColorButton);
        jpanel.add(secondaryColorButton);

        toolBar.add(jpanel);
    }

    private void populateToolViewList() {
        File toolsFolder = new File(ToolbarView.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/tools/");
        File[] fileList = toolsFolder.listFiles();
        String extension , nameWithExtension , nameWithoutExtension , outerClassName = "";

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

    public Drawing getDrawing() {
        return drawing;
    }

    public List<ToolView> getToolViewList() {
        return toolViewList;
    }

    public JButton getMainColorButton() {
        return mainColorButton;
    }

    public JButton getSecondaryColorButton() {
        return secondaryColorButton;
    }
}
