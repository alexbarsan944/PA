import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame()
    {
        DesignPanel designPanel = new DesignPanel();
        ControlPanel controlPanel = new ControlPanel(designPanel);
        controlPanel.setBounds(0,0,1200,60);
        designPanel.setBounds(0, 100, 1200,600);
        designPanel.addMouseListener(new onClick(designPanel, controlPanel));
        this.setSize(1200, 600);
        this.add(controlPanel);
        this.add(designPanel);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);

    }
}