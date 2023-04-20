package myPresentation;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(String title, Color backgroundColor){
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(new Color(85, 86, 98));
        this.setFont(new Font("CALIBRE",Font.BOLD+Font.ITALIC,24));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque((true));
    }
}
