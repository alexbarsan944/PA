import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;

public class onClick implements MouseListener {
    DesignPanel designPanel;
    ControlPanel controlPanel;
    Point begin;
    Point end;
    public void setJComponent(JComponent object)
    {
        String className = controlPanel.getText();
        object.addMouseListener(this);
        object.setBackground(Color.WHITE);
        object.setFocusable(true);
        object.setName(className + " class");
        object.setBounds(this.begin.x, this.begin.y-50,this.end.x - this.begin.x, this.end.y - this.begin.y);
    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        end = mouseEvent.getLocationOnScreen();

        String className = controlPanel.getText();
        try {
            Class<?> clazz = Class.forName(className);
            JComponent object = (JComponent) clazz.getDeclaredConstructor().newInstance();
            setJComponent(object);
            designPanel.add(object);
            designPanel.revalidate();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public onClick(DesignPanel designPanel, ControlPanel controlPanel) {
        this.designPanel = designPanel;
        this.controlPanel = controlPanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        begin = mouseEvent.getLocationOnScreen();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
