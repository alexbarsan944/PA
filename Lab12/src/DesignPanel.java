import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    JTextArea text;
    public String getText() {
        return text.getText();
    }
    public DesignPanel() {
        this.setLayout(null);
        this.setBackground(Color.black);
    }



}