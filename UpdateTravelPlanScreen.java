import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class UpdateTravelPlanScreen extends JPanel {

    public static final Map<String, TravelPlan> travelPlans = ViewTravelPlanScreen.travelPlans;

    public UpdateTravelPlanScreen(JFrame frame, String planId) {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        TravelPlan plan = travelPlans.get(planId);

        JLabel titleLabel = new JLabel("Update Travel Plan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(300, 40, 200, 50);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(250, 120, 80, 30);
        add(nameLabel);

        JTextField nameField = new JTextField(plan.getName());
        nameField.setBounds(340, 120, 200, 30);
        add(nameField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(250, 160, 80, 30);
        add(dateLabel);

        JTextField dateField = new JTextField(plan.getDate());
        dateField.setBounds(340, 160, 200, 30);
        add(dateField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(250, 200, 80, 30);
        add(destinationLabel);

        JTextField destinationField = new JTextField(plan.getDestination());
        destinationField.setBounds(340, 200, 200, 30);
        add(destinationField);

        JLabel budgetLabel = new JLabel("Budget ($):");
        budgetLabel.setBounds(250, 240, 80, 30);
        add(budgetLabel);

        JTextField budgetField = new JTextField(String.valueOf(plan.getBudget()));
        budgetField.setBounds(340, 240, 200, 30);
        add(budgetField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(300, 300, 100, 30);
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
        backButton.setBounds(410, 300, 100, 30);
        backButton.setBackground(Color.RED);
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(new ViewTravelPlanScreen(frame)); // Go back to View Travel Plans
            frame.revalidate();
            frame.repaint();
        });
        add(backButton);
    }

    // TravelPlan class to hold travel plan data
    public static class TravelPlan {
      private String name;
      private String date;
      private String destination;
      private double budget;
  
      // Constructor accepting name, date, destination, and budget
      public TravelPlan(String name, String date, String destination, double budget) {
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
