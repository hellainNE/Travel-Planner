
import java.awt.*;
import java.awt.event.*;

/////////MAIN
public class Main {
    public static void main(String[] args) {

// frame
    Frame frame1 = new Frame("Travel Planner");
    frame1.setSize(800, 500);
    frame1.setLocation(250,100);
    frame1.setLayout(null);
    frame1.setVisible(true);

// Welcome Label
    Label aLabel = new Label("WELCOME TO TRAVEL PLANNER");
    aLabel.setAlignment(Label.CENTER);  
    Font font1 = new Font("Arial", Font.BOLD, 20);
    aLabel.setFont(font1);

// password label
    Label bLabel = new Label("Enter your Password");
    Font font2 = new Font("Arial", Font.BOLD, 14);
    bLabel.setFont(font2);

//password textfield
    TextField passwordField = new TextField(20);
    passwordField.setEchoChar('*');
       
//button
    Button enterButton = new Button("Enter");  
    enterButton.setFont(new Font("Arial", Font.BOLD, 14));
    enterButton.setBackground(Color.GREEN); 
    enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
   
// Add components to the main panel
    frame1.add(aLabel);
    frame1.add(bLabel);
    frame1.add(passwordField);
    frame1.add(enterButton);

//position or ialign sa center ang label and textfield
    frame1.addComponentListener(new ComponentAdapter() {
    
public void componentResized(ComponentEvent e) {
    int frameWidth = frame1.getWidth();
    aLabel.setBounds((frameWidth - 400) / 2, 40, 400, 50);
    bLabel.setBounds((frameWidth - 150) / 2, 120, 150, 30);
    passwordField.setBounds((frameWidth - 200) / 2, 150, 200, 30);
    enterButton.setBounds((frameWidth - 150) / 2, 220, 150, 30);
    }
});

//action listener for enter button for (password)
    enterButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
    String password = passwordField.getText();

    if (password.equals("123")) {
        frame1.removeAll();
        openHomeScreen(frame1);
    } else {
        Label inpassLabel = new Label("Incorrect password! Please try again.");
        Font font4 = new Font("Arial", Font.BOLD, 14);
        inpassLabel.setFont(font4);
        inpassLabel.setAlignment(Label.CENTER);

// Position the label in the center
    inpassLabel.setBounds((frame1.getWidth() - 300) / 2, 180, 320, 30);
    frame1.add(inpassLabel);

//para ni mu automatic ug appear ang home screen
    frame1.setSize(frame1.getWidth() + 1, frame1.getHeight());
    frame1.setSize(frame1.getWidth() - 1, frame1.getHeight());
    }
    }
});

//closing the window if i X nmo
    frame1.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    });

}
////////HOME SCREEN
 // a new frame for the home screen
public static void openHomeScreen(Frame frame) {
    
    Label homeLabel = new Label("Select an Option:");
    homeLabel.setAlignment(Label.CENTER);
    Font font3 = new Font("Arial", Font.BOLD, 16);
    homeLabel.setFont(font3);  
//button for each options
    Button addButton = new Button("Add Travel Plan");
    Button updateButton = new Button("Update Travel Plan");
    Button viewButton = new Button("View Travel Plan");
    Button deleteButton = new Button("Delete Travel Plan");
    Font buttonFont = new Font("Arial", Font.BOLD, 14);

    addButton.setFont(buttonFont);
    updateButton.setFont(buttonFont);
    viewButton.setFont(buttonFont);
    deleteButton.setFont(buttonFont);

//exit button
    Button exitButton = new Button("Exit");
    exitButton.setFont(new Font("Arial", Font.BOLD, 14));
    exitButton.setBackground(Color.RED);
    exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

// para ma display to the frame
    frame.add(homeLabel);
    frame.add(exitButton);
    frame.add(homeLabel);
    frame.add(addButton);
    frame.add(updateButton);
    frame.add(viewButton);
    frame.add(deleteButton);

//position or ialign sa center ang label and textfield, button
    frame.addComponentListener(new ComponentAdapter() {

public void componentResized(ComponentEvent e) {
    int frameWidth = frame.getWidth();
    homeLabel.setBounds((frameWidth - 200) / 2, 40, 200, 50);
    exitButton.setBounds((frameWidth - 150) / 2, 350, 150, 30);
    addButton.setBounds((frameWidth - 200) / 2, 120, 200, 40);
    updateButton.setBounds((frameWidth - 200) / 2, 180, 200, 40);
    viewButton.setBounds((frameWidth - 200) / 2, 240, 200, 40);
    deleteButton.setBounds((frameWidth - 200) / 2, 300, 200, 40);
    }
    });

//action listener for enter button for (all options)
ActionListener addActionListener2 = new ActionListener(){
public void actionPerformed(ActionEvent e){
    String action = e.getActionCommand();

    if(action.equals("Add Travel Plan")){
        frame.removeAll();
        openAddTravel(frame);
    }else if(action.equals("Update Travel Plan")){
        frame.removeAll();

    }else if(action.equals("View Travel Plan")){
        frame.removeAll();

    }else if(action.equals("Delete Travel Plan")){
        frame.removeAll();

    }else{
        Label errorLabel = new Label("Invalid option selected!");
        errorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        errorLabel.setAlignment(Label.CENTER);
        errorLabel.setBounds((frame.getWidth() - 300) / 2, 400, 300, 30);
        frame.add(errorLabel);
//para ni mu automatic ug appear ang home screen
        frame.setSize(frame.getWidth() + 1, frame.getHeight());
        frame.setSize(frame.getWidth() - 1, frame.getHeight());
    }
    }   
};
// Assign action commands to buttons
    addButton.setActionCommand("Add Travel Plan");
    updateButton.setActionCommand("Update Travel Plan");
    viewButton.setActionCommand("View Travel Plan");
    deleteButton.setActionCommand("Delete Travel Plan");
//for action na mu perform ni sla all
    addButton.addActionListener(addActionListener2);
    updateButton.addActionListener(addActionListener2);
    viewButton.addActionListener(addActionListener2);
    deleteButton.addActionListener(addActionListener2);

//////sa exit ni
// Add exit functionality
    exitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    
    frame.removeAll(); 
    main(null); 
    }
    });
//para ni mu automatic ug appear ang home screen
    frame.setSize(frame.getWidth() + 1, frame.getHeight());
    frame.setSize(frame.getWidth() - 1, frame.getHeight()); 
}

//////////ADD TRAVEL
public static void openAddTravel(Frame frame) {
    //label for add travel
    Label addLabel = new Label("Add Travel Plan");
    addLabel.setAlignment(Label.CENTER);
    Font font4 = new Font("Arial", Font.BOLD, 16);
    addLabel.setFont(font4);
//fields and labels for name, date, destination and button save and back
    Label nameLabel = new Label("Name:");
    TextField nameField = new TextField(20);

    Label dateLabel = new Label("Date:");
    TextField dateField = new TextField(20);

    Label destinationLabel = new Label("Destination:");
    TextField destinationField = new TextField(20);
//  Save Button
    Button saveButton = new Button("Save");
    saveButton.setFont(new Font("Arial", Font.BOLD, 14));
    saveButton.setBackground(Color.GREEN);
    saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//  Back Button
   Button backButton = new Button("Back");
   backButton.setFont(new Font("Arial", Font.BOLD, 14));
   backButton.setBackground(Color.RED);
   backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
// Add components to the frame
   frame.add(addLabel);
   frame.add(nameLabel);
   frame.add(nameField);
   frame.add(dateLabel);
   frame.add(dateField);
   frame.add(destinationLabel);
   frame.add(destinationField);
   frame.add(saveButton);
   frame.add(backButton);
 // Positioning the components
    frame.addComponentListener(new ComponentAdapter() {
public void componentResized(ComponentEvent e) {
    int frameWidth = frame.getWidth();
    addLabel.setBounds((frameWidth - 200) / 2, 40, 200, 40);
    nameLabel.setBounds((frameWidth - 400) / 2, 100, 80, 30);
    nameField.setBounds((frameWidth - 500) / 1, 100, 300, 30);
    dateLabel.setBounds((frameWidth - 400) / 2, 150, 80, 30);
    dateField.setBounds((frameWidth - 500) / 1, 150, 300, 30);
    destinationLabel.setBounds((frameWidth - 400) / 2, 200, 80, 30);
    destinationField.setBounds((frameWidth - 500) / 1, 200, 300, 30);
    saveButton.setBounds((frameWidth - 150) / 2, 270, 150, 30);
    backButton.setBounds((frameWidth - 150) / 2, 320, 150, 30);
    }
});

// Add ActionListener for Save Button
    saveButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
    String name = nameField.getText();
    String date = dateField.getText();
    String destination = destinationField.getText();

    if (name.isEmpty() || date.isEmpty() || destination.isEmpty()) {
        Label errorLabel = new Label("All fields are required!");
        errorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        errorLabel.setAlignment(Label.CENTER);
        errorLabel.setBounds((frame.getWidth() - 300) / 2, 370, 300, 30);
        frame.add(errorLabel);
//para ni mu automatic ug appear ang home screen
        frame.setSize(frame.getWidth() + 1, frame.getHeight());
        frame.setSize(frame.getWidth() - 1, frame.getHeight());
    } else {
// Simulate saving the data (wapa ni tan awn natog ma apply ni sa view)
    System.out.println("Travel Plan Added:");
    System.out.println("Name: " + name);
    System.out.println("Date: " + date);
    System.out.println("Destination: " + destination);
//message for successful save
    Label successLabel = new Label("Travel Plan Saved Successfully!");
    successLabel.setFont(new Font("Arial", Font.BOLD, 14));
    successLabel.setAlignment(Label.CENTER);
    successLabel.setBounds((frame.getWidth() - 300) / 2, 370, 300, 30);
    frame.add(successLabel);
//para ni mu automatic ug appear ang home screen
    frame.setSize(frame.getWidth() + 1, frame.getHeight());
    frame.setSize(frame.getWidth() - 1, frame.getHeight());
    }
}
});
  // Add ActionListener for Back Button
    backButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
    frame.removeAll();
    openHomeScreen(frame); // Return to the Home Screen
}
});
  // Refresh the frame
  frame.setSize(frame.getWidth() + 1, frame.getHeight());
  frame.setSize(frame.getWidth() - 1, frame.getHeight());
}

}
