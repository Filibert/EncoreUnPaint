package controller;

import tools.ToolController;
import tools.ToolView;
import view.MainFrame;
import view.ToolbarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ToolbarController {
    private final MainFrame mainFrame;
    private final ToolbarView toolbarView;

    private Map<ToolView, ToolController> toolControllerMap = new HashMap<>();
    private ToolController activeToolController = null;

    public ToolbarController(MainFrame mainFrame, ToolbarView toolbarView) {
        this.mainFrame = mainFrame;
        this.toolbarView = toolbarView;

        populateToolControllerList();

        for(Map.Entry<ToolView, ToolController> entry : toolControllerMap.entrySet())
        {
            entry.getKey().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    setActiveToolController(entry.getValue());
                }
            });
        }
        
        handleColorSelect();
    }

    private void handleColorSelect() {

        toolbarView.getMainColorButton().addActionListener(e -> {
            Color mainColor = JColorChooser.showDialog(null,"Main color",null);
            toolbarView.getMainColorButton().setBackground(mainColor);
            mainFrame.getDrawingView().getDrawing().setMainColorSelected(mainColor);
        });

        toolbarView.getSecondaryColorButton().addActionListener(e -> {
            Color secondaryColor = JColorChooser.showDialog(null,"Secondary Color",null);
            toolbarView.getMainColorButton().setBackground(secondaryColor);
            mainFrame.getDrawingView().getDrawing().setSecondaryColorSelected(secondaryColor);
        });

        toolbarView.getMainColorButton().setBackground(mainFrame.getDrawingView().getDrawing().getMainColorSelected());
        toolbarView.getSecondaryColorButton().setBackground(mainFrame.getDrawingView().getDrawing().getSecondaryColorSelected());

    }

    private void populateToolControllerList() {
     /*   File toolsFolder = new File(ToolbarView.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/tools/");
        File[] fileList = toolsFolder.listFiles();
        String extension , nameWithExtension , nameWithoutExtension ,toolView="",toolController="", outerClassName = "";
        ArrayList<String> nameWithoutExtensionList = new ArrayList<String>(fileList.length);

        for(File file : fileList){
            nameWithExtension = file.getName();
            extension = nameWithExtension.substring(nameWithExtension.lastIndexOf("."));
            nameWithoutExtension = nameWithExtension.substring(0,nameWithExtension.lastIndexOf("."));
            if(".class".equals(extension)) {
                nameWithoutExtensionList.add(nameWithoutExtension);
            }
        }
        for(String className : nameWithoutExtensionList){
            if(!className.contains("$") && !"ToolController".equals(className) && !"ToolView".equals(className)){
                outerClassName = className;
                if(nameWithoutExtensionList.contains(outerClassName + "$"+outerClassName+"View") && nameWithoutExtensionList.contains(outerClassName + "$"+outerClassName+"Controller")) {
                    toolView = "tools." + outerClassName + "$" + outerClassName + "View";
                    toolController = "tools." + outerClassName + "$" + outerClassName + "Controller";
                    try {
                        Class<?> tool = Class.forName("tools."+outerClassName);
                        Object o = tool.newInstance();

                        Class<?> toolViewClass = Class.forName(toolView);
                        Constructor<?> ctor = toolViewClass.getDeclaredConstructor(tool);
                        Object view =  ctor.newInstance(o);

                        Class<?> toolControllerClass = Class.forName(toolController);
                        Constructor<?> constructorController = toolControllerClass.getConstructors()[0];
                        Object controller = constructorController.newInstance(o,mainFrame,view);

                        System.out.println(toolControllerClass.getConstructors()[0].getParameterTypes()[0]);
                        System.out.println(o.getClass());

                        toolControllerMap.put((ToolView) view,(ToolController) controller);
                    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException e){
                        e.printStackTrace();
                    }

                }
            }

        }*/

        List<ToolView> toolsViewList = mainFrame.getToolbarView().getToolViewList();
        for (ToolView toolView:toolsViewList) {
            String outerClassName = toolView.getClass().getName().substring(toolView.getClass().getName().indexOf(".")+1,toolView.getClass().getName().lastIndexOf("$"));
            System.out.println(outerClassName);
            try {
                Class<?> tool = Class.forName("tools."+outerClassName);
                Object o = tool.newInstance();

                Class<?> toolControllerClass = Class.forName("tools."+outerClassName+"$"+outerClassName+"Controller");
                Constructor<?> constructorController = toolControllerClass.getConstructors()[0];
                Object controller = constructorController.newInstance(o,mainFrame,toolView);

                System.out.println(toolControllerClass.getConstructors()[0].getParameterTypes()[0]);
                System.out.println(o.getClass());

                toolControllerMap.put( toolView,(ToolController) controller);
            } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }


    }

    public ToolbarView getToolbarView() {
        return toolbarView;
    }

    private void setActiveToolController(ToolController activeToolController) {

        if (this.activeToolController != null) {
            this.activeToolController.onDeselectTool();
        }

        this.activeToolController = activeToolController;

        if(activeToolController != null) {
            activeToolController.onSelectTool();
            mainFrame.getFooterView().getLabel().setText(activeToolController.getHelpText());
        }
        else
            mainFrame.getFooterView().getLabel().setText("");
    }
}
