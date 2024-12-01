import javax.swing.*;
import java.awt.*;

public class AddTravelPlanScreen extends JPanel {

    public Image backgroundImage; // Placeholder for background image

    public AddTravelPlanScreen(JFrame frame) {
        setLayout(null);
        backgroundImage = new ImageIcon("background3.jpg").getImage();

        JLabel titleLabel = new JLabel("CREATE YOUR TRAVEL PLAN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        titleLabel.setBounds(280, 60, 350, 50);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(290, 140, 80, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(370, 140, 250, 30);
        add(nameField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(290, 180, 80, 30);
        add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(370, 180, 250, 30);
        add(dateField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(290, 220, 80, 30);
        add(destinationLabel);

        JTextField destinationField = new JTextField();
        destinationField.setBounds(370, 220, 250, 30);
        add(destinationField);

        // Add a Budget field here
        JLabel budgetLabel = new JLabel("Budget (₱):");
        budgetLabel.setBounds(290, 260, 80, 30);
        add(budgetLabel);

        JTextField budgetField = new JTextField(); // Declare the budget field here
        budgetField.setBounds(370, 260, 250, 30);
        add(budgetField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(370, 330, 100, 30);
        saveButton.setBackground(Color.GREEN); // Travel vibes blue
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String date = dateField.getText().trim();
            String destination = destinationField.getText().trim();
            String budgetText = budgetField.getText().trim(); // Get budget as a string
            
             // Check if any field is empty
    if (name.isEmpty() || date.isEmpty() || destination.isEmpty() || budgetText.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Stop further processing if fields are empty
    }
            // Make sure to parse the budget field value
            double budget;
    try {
        budget = Double.parseDouble(budgetText); // Parse budget as double
        if (budget <= 0) {
            JOptionPane.showMessageDialog(frame, "Budget must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Please enter a valid number for budget.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

           // If all validations pass, proceed to add the travel plan
    String planId = String.valueOf(System.currentTimeMillis()); // Use timestamp as ID
    ViewTravelPlanScreen.travelPlans.put(planId, new UpdateTravelPlanScreen.travelPlans(name, date, destination, budget));

    JOptionPane.showMessageDialog(frame, "Travel Plan Added!", "Success", JOptionPane.INFORMATION_MESSAGE);

    frame.getContentPane().removeAll();
    frame.add(new HomeScreen(frame));
    frame.revalidate();
    frame.repaint();
        });
        add(saveButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(500, 330, 100, 30);
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