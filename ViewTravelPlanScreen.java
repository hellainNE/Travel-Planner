import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ViewTravelPlanScreen extends JPanel {

    // Shared static map to store travel plans (connected with Add and Update screens)
    public static final Map<String, UpdateTravelPlanScreen.TravelPlan> travelPlans = new java.util.HashMap<>();
    private Image backgroundImage; // Placeholder for background image

    public ViewTravelPlanScreen(JFrame frame) {
        setLayout(null);
        backgroundImage = new ImageIcon("background3.jpg").getImage(); // Set your background image path
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Your Travel Plans", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(250, 40, 300, 50);
        add(titleLabel);

        if (travelPlans.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No travel plans available. Please add a travel plan first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            frame.getContentPane().removeAll();
            frame.add(new HomeScreen(frame));  // Return to the home screen if no plans
            frame.revalidate();
            frame.repaint();
            return;
        }

        // Display all travel plans with options to update or delete
        int yPosition = 120;
        for (Map.Entry<String, UpdateTravelPlanScreen.TravelPlan> entry : travelPlans.entrySet()) {
            String planId = entry.getKey();
            UpdateTravelPlanScreen.TravelPlan plan = entry.getValue();

            // Create a panel to display each travel plan neatly
            JPanel planPanel = new JPanel();
            planPanel.setBounds(150, yPosition, 500, 100);  // Adjusted size for budget space
            planPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            planPanel.setBackground(new Color(255, 255, 255, 180)); // Semi-transparent white background

            // Add plan information including budget
            JLabel planLabel = new JLabel("<html><b>Name:</b> " + plan.getName() +
                    "<br><b>Date:</b> " + plan.getDate() +
                    "<br><b>Destination:</b> " + plan.getDestination() +
                    "<br><b>Budget:</b> $" + plan.getBudget() + "</html>");  // Added budget
            planLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            planPanel.add(planLabel);

            // Add buttons for updating and deleting travel plans
            JButton updateButton = new JButton("Update");
            updateButton.setBackground(new Color(0, 128, 255)); // Travel vibes blue
            updateButton.setForeground(Color.WHITE);
            updateButton.addActionListener(e -> {
                frame.getContentPane().removeAll();
                frame.add(new UpdateTravelPlanScreen(frame, planId)); // Pass the planId to Update screen
                frame.revalidate();
                frame.repaint();
            });

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(Color.RED);
            deleteButton.setForeground(Color.WHITE);
            deleteButton.addActionListener(e -> {
                // Remove the selected travel plan
                travelPlans.remove(planId);
                JOptionPane.showMessageDialog(frame, "Travel Plan Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Refresh the view after deleting
                frame.getContentPane().removeAll();
                frame.add(new ViewTravelPlanScreen(frame));
                frame.revalidate();
                frame.repaint();
            });

            planPanel.add(updateButton);
            planPanel.add(deleteButton);
            add(planPanel);

            yPosition += 120; // Increase the vertical space for the next travel plan
        }

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(350, yPosition, 100, 30);
        backButton.setBackground(Color.RED);
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(new HomeScreen(frame)); // Go back to the home screen
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