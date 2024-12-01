import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ViewTravelPlanScreen extends JPanel {

// Shared static map to store travel plans (connected with Add and Update screens)
    public static final Map<String, UpdateTravelPlanScreen.travelPlans> travelPlans = new java.util.HashMap<>();
    private Image backgroundImage; 

    public ViewTravelPlanScreen(JFrame frame) {
        setLayout(null);
        backgroundImage = new ImageIcon("background3.jpg").getImage(); 
//text label and field
        JLabel titleLabel = new JLabel("Your Travel Plans", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(300, 40, 300, 50);
        add(titleLabel);

        if (travelPlans.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No travel plans available. Please add a travel plan first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            frame.getContentPane().removeAll();
            frame.add(new HomeScreen(frame));  
            frame.revalidate();
            frame.repaint();
            return;
        }

// Display all travel plans with options to update or delete
        int yPosition = 120;
        for (Map.Entry<String, UpdateTravelPlanScreen.travelPlans> entry : travelPlans.entrySet()) {
            String planId = entry.getKey();
            UpdateTravelPlanScreen.travelPlans plan = entry.getValue();

//a panel to display each travel plan 
            JPanel planPanel = new JPanel();
            planPanel.setBounds(170, yPosition, 600, 100);  
            planPanel.setLayout(null); 
            planPanel.setBackground(new Color(255, 255, 255, 180)); 

            JLabel planLabel = new JLabel("<html><b>Name:</b> " + plan.getName() +
                    "<br><b>Date:</b> " + plan.getDate() +
                    "<br><b>Destination:</b> " + plan.getDestination() +
                    "<br><b>Budget:</b> ₱" + plan.getBudget() + "</html>");  
            planLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            planLabel.setBounds(15, 15, 500, 70); 
            planPanel.add(planLabel);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setOpaque(false);

// buttons for updating and deleting 
            JButton updateButton = new JButton("Update");
            updateButton.setBackground(Color.green); 
            updateButton.setForeground(Color.WHITE);
            updateButton.setBounds(500, 10, 80, 30); 
            updateButton.addActionListener(e -> {
                frame.getContentPane().removeAll();
                frame.add(new UpdateTravelPlanScreen(frame, planId)); 
                frame.revalidate();
                frame.repaint();
            });

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(Color.RED);
            deleteButton.setForeground(Color.WHITE);
            deleteButton.setBounds(500, 50, 80, 30); 
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
// Increase the vertical space for the next travel plan
            yPosition += 120; 
        }

// Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(400, yPosition, 100, 30);
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