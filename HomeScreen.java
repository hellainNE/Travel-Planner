import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel {

    private Image backgroundImage; // Placeholder for background image

    public HomeScreen(JFrame frame) {
        setLayout(null);
        setBackground(Color.ORANGE); // Remove this if using a background image
        backgroundImage = new ImageIcon("path/to/your/image.jpg").getImage(); // Set your background image path

        JLabel titleLabel = new JLabel("Select an Option:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(300, 40, 200, 50);

        JButton addButton = createButton("Add Travel Plan", 120, e -> openAddTravel(frame));
        JButton viewButton = createButton("View Travel Plan", 180, e -> openViewTravel(frame));

        add(titleLabel);
        add(addButton);
        add(viewButton);
    }

    private JButton createButton(String text, int y, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBounds(300, y, 200, 40);
        button.setBackground(new Color(0, 128, 255)); // Travel vibes blue
        button.setForeground(Color.WHITE);
        button.addActionListener(action);
        return button;
    }

    private void openAddTravel(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.add(new AddTravelPlanScreen(frame));
        frame.revalidate();
        frame.repaint();
    }

    private void openViewTravel(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.add(new ViewTravelPlanScreen(frame));
        frame.revalidate();
        frame.repaint();
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
