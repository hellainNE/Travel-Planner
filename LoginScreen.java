import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScreen extends JPanel {

    private Image backgroundImage; // Placeholder for background image

    public LoginScreen(JFrame frame) {
        setLayout(null);
        setBackground(Color.ORANGE); // Remove this if using a background image
        backgroundImage = new ImageIcon("path/to/your/image.jpg").getImage(); // Set your background image path

        JLabel welcomeLabel = new JLabel("WELCOME TO TRAVEL PLANNER", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBounds(200, 40, 400, 50);

        JLabel passwordLabel = new JLabel("Enter your Password", SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(325, 120, 150, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(300, 160, 200, 30);

        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 14));
        enterButton.setBackground(new Color(0, 128, 255)); // Travel vibes blue
        enterButton.setBounds(325, 220, 150, 30);
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
