
import java.awt.*;
import java.awt.event.*;

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
    
    public void actionPerformed(ActionEvent e){
    String password = passwordField.getText();
    if(password.equals("123")){
        frame1.removeAll();
        openHomeScreen(frame1);
    }else{
        System.out.println("Incorrect password!...");
    }
    frame1.repaint();
    }
    });
 
//closing the window
    frame1.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
            System.exit(0);
    }
    });
}

 // a new frame for the home screen
    public static void openHomeScreen(Frame frame) {

    Label homeLabel =  new Label("Home Screen Sample!");
    homeLabel.setAlignment(Label.CENTER);
    Font font3 = new Font("Arial", Font.BOLD, 16);
    homeLabel.setFont(font3);   

    Button exitButton = new Button("Exit");
    exitButton.setFont(new Font("Arial", Font.BOLD, 14));
    exitButton.setBackground(Color.RED);
    exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

// Add components to the frame
    frame.add(homeLabel);
    frame.add(exitButton);

//position or ialign sa center ang label and textfield, button
    frame.addComponentListener(new ComponentAdapter() {
    public void componentResized(ComponentEvent e) {
    int frameWidth = frame.getWidth();
    homeLabel.setBounds((frameWidth - 200) / 2, 40, 200, 50);
    exitButton.setBounds((frameWidth - 150) / 2, 320, 150, 30);
    }
    });

// Add logout functionality
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
}
