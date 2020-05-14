
import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    JTextArea text;
    DesignPanel designPanel;
    public ControlPanel(DesignPanel designPanel) {
        this.designPanel= designPanel;
        this.setLayout(new GridBagLayout());
        text = new JTextArea(1,30);
        JButton select = new JButton("SELECT");
        text.setPreferredSize(new Dimension(350, 20));
        this.add(text);
        this.add(select);
    }

    public String getText() {
        return text.getText();
    }

}