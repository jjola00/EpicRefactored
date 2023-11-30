import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
interface GFrame {
    default JButton createButton(int x, int y, String text, ActionListener actionListener, ImageIcon icon) {
        JButton button = new JButton();
        button.setBounds(x, y, 600, 200);
        button.setText(text);
        button.setFont(new Font("Monospaced", Font.BOLD, 25));
        button.setFocusable(false);
        button.setIcon(icon);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button.addActionListener(actionListener);
        return button;
    }
}
