import javax.swing.*;
import java.awt.*;

public class AddTravelPlanScreen extends JPanel {

    private Image backgroundImage; // Placeholder for background image

    public AddTravelPlanScreen(JFrame frame) {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY); // Remove this if using a background image
        backgroundImage = new ImageIcon("path/to/your/image.jpg").getImage(); // Set your background image path

        JLabel titleLabel = new JLabel("Add Travel Plan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(300, 40, 200, 50);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(250, 120, 80, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(340, 120, 200, 30);
        add(nameField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(250, 160, 80, 30);
        add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(340, 160, 200, 30);
        add(dateField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(250, 200, 80, 30);
        add(destinationLabel);

        JTextField destinationField = new JTextField();
        destinationField.setBounds(340, 200, 200, 30);
        add(destinationField);

        // Add a Budget field here
        JLabel budgetLabel = new JLabel("Budget ($):");
        budgetLabel.setBounds(250, 240, 80, 30);
        add(budgetLabel);

        JTextField budgetField = new JTextField(); // Declare the budget field here
        budgetField.setBounds(340, 240, 200, 30);
        add(budgetField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(300, 300, 100, 30);
        saveButton.setBackground(new Color(0, 128, 255)); // Travel vibes blue
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String date = dateField.getText();
            String destination = destinationField.getText();
            
            // Make sure to parse the budget field value
            double budget = 0;
            try {
                budget = Double.parseDouble(budgetField.getText()); // Parse the budget as double
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number for budget.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further processing if there's an invalid number
            }

            if (name.isEmpty() || date.isEmpty() || destination.isEmpty() || budget <= 0) {
                JOptionPane.showMessageDialog(frame, "All fields are required and budget must be greater than zero!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String planId = String.valueOf(System.currentTimeMillis()); // Use timestamp as ID
                // Use the constructor with 4 parameters
                ViewTravelPlanScreen.travelPlans.put(planId, new UpdateTravelPlanScreen.TravelPlan(name, date, destination, budget));

                JOptionPane.showMessageDialog(frame, "Travel Plan Added!", "Success", JOptionPane.INFORMATION_MESSAGE);

                frame.getContentPane().removeAll();
                frame.add(new HomeScreen(frame));
                frame.revalidate();
                frame.repaint();
            }
        });
        add(saveButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(410, 300, 100, 30);
        backButton.setBackground(Color.RED);
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(new HomeScreen(frame)); 
            frame.revalidate();
            frame.repaint();
        });
        add(backButton);
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
