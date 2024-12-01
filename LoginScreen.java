import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScreen extends JPanel {

    private Image backgroundImage; 
    public LoginScreen(JFrame frame) {
        setLayout(null);
        //for bckg image
        backgroundImage = new ImageIcon("background3.jpg").getImage(); 

        JLabel welcomeLabel = new JLabel("WELCOME TO TRAVEL PLANNER", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Georgia", Font.BOLD, 28));
        welcomeLabel.setBounds(210, 40, 500, 130);

        JLabel passwordLabel = new JLabel("Enter your Password", SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(370, 198, 150, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(320, 230, 250, 33);

        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 14));
        enterButton.setBackground(Color.GREEN);
        enterButton.setBounds(370, 315, 150, 40);
        enterButton.addActionListener((ActionEvent e) -> {
            String password = new String(passwordField.getPassword());
            if ("123".equals(password)) {
                frame.getContentPane().removeAll();
                frame.add(new HomeScreen(frame));
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect password! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(welcomeLabel);
        add(passwordLabel);
        add(passwordField);
        add(enterButton);
    }

    // Override paintComponent to add background image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}