import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class UpdateTravelPlanScreen extends JPanel {

    public static final Map<String, travelPlans> travelPlans = ViewTravelPlanScreen.travelPlans;
    private Image backgroundImage;

    public UpdateTravelPlanScreen(JFrame frame, String planId) {
        setLayout(null);
        backgroundImage = new ImageIcon("background3.jpg").getImage();

        travelPlans plan = travelPlans.get(planId);

        JLabel titleLabel = new JLabel("Update Travel Plan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        titleLabel.setBounds(288, 60, 350, 50);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(290, 140, 80, 30);
        add(nameLabel);

        JTextField nameField = new JTextField(plan.getName());
        nameField.setBounds(370, 140, 250, 30);
        add(nameField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(290, 180, 80, 30);
        add(dateLabel);

        JTextField dateField = new JTextField(plan.getDate());
        dateField.setBounds(370, 180, 250, 30);
        add(dateField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(290, 220, 80, 30);
        add(destinationLabel);

        JTextField destinationField = new JTextField(plan.getDestination());
        destinationField.setBounds(370, 220, 250, 30);
        add(destinationField);

        JLabel budgetLabel = new JLabel("Budget (₱):");
        budgetLabel.setBounds(290, 260, 80, 30);
        add(budgetLabel);

        JTextField budgetField = new JTextField(String.valueOf(plan.getBudget()));
        budgetField.setBounds(370, 260, 250, 30);
        add(budgetField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(370, 330, 100, 30);
        saveButton.setBackground(Color.GREEN);
        saveButton.addActionListener(e -> {
            plan.setName(nameField.getText());
            plan.setDate(dateField.getText());
            plan.setDestination(destinationField.getText());
            plan.setBudget(Double.parseDouble(budgetField.getText()));

            JOptionPane.showMessageDialog(frame, "Travel Plan Updated!", "Success", JOptionPane.INFORMATION_MESSAGE);

            frame.getContentPane().removeAll();
            frame.add(new ViewTravelPlanScreen(frame));
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
            frame.add(new ViewTravelPlanScreen(frame));
            frame.revalidate();
            frame.repaint();
        });
        add(backButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    //travel plan for storage class
    
    public static class travelPlans {
        private String name;
        private String date;
        private String destination;
        private double budget;
  
        // Constructor accepting name, date, destination, and budget
        public travelPlans(String name, String date, String destination, double budget) {
            this.name = name;
            this.date = date;
            this.destination = destination;
            this.budget = budget;
        }
  
        // Getters and Setters
        public String getName() {
            return name;
        }
  
        public void setName(String name) {
            this.name = name;
        }
  
        public String getDate() {
            return date;
        }
  
        public void setDate(String date) {
            this.date = date;
        }
  
        public String getDestination() {
            return destination;
        }
  
        public void setDestination(String destination) {
            this.destination = destination;
        }
  
        public double getBudget() {
            return budget;
        }
  
        public void setBudget(double budget) {
            this.budget = budget;
        }
    }
}
