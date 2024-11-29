import javax.swing.*; 

public class Main {
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Travel Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);

        //mu show ang log in
        frame.add(new LoginScreen(frame));
        frame.setVisible(true);
    });
}
}