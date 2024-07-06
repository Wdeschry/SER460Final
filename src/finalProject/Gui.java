package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*
 *  Main GUI class
 *  Currently contains placeholder functionality
 */

public class Gui {
    public static void main(String[] args) {
    	/*****************************************************************
    	 * Placeholder for creating the pub/sub system when it is finished
    	 ****************************************************************/
    	Broker broker = new Broker();
        Subscriber subscriber = new Subscriber(broker, "Default Subscriber");
        Publisher publisher = new Publisher(broker, "Default Publisher");
    	
        /****************
         * Main window
         ****************/
    	// Window
        JFrame frame = new JFrame("SER450 Final");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Top half
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        frame.setLayout(new GridLayout(2, 1));

        // Bottom half
        JTextArea bottomTextArea = new JTextArea();
        bottomTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bottomTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        /********************************
         * Top Left Section (publishers)
         ********************************/
        // Declare the elements
        JPanel topLeft = new JPanel(new GridLayout(6,2));
        JTextField pubUsernameField = new JTextField("", 10);
        JTextField pubCuisineField = new JTextField("", 10);
        JTextField pubMealField = new JTextField("", 10);
        JTextField pubTimeField = new JTextField("", 10);
        JTextField pubDayField = new JTextField("", 10);
        JButton pubButton = new JButton("Publish");
        // Pass the parameters to the button when clicked
        pubButton.addActionListener(e -> pubButtonAction(e, 
        		pubUsernameField.getText(),
        		pubCuisineField.getText(),
        		pubMealField.getText(),
        		pubTimeField.getText(),
        		pubDayField.getText(),
        		bottomTextArea));
        
        // Add the elements in order to the panel
        topLeft.add(new JLabel("Username:"));
        topLeft.add(pubUsernameField);
        topLeft.add(new JLabel("Cuisine Type:"));
        topLeft.add(pubCuisineField);
        topLeft.add(new JLabel("Meal Name:"));
        topLeft.add(pubMealField);
        topLeft.add(new JLabel("Time of Meal:"));
        topLeft.add(pubTimeField);
        topLeft.add(new JLabel("Day of Meal:"));
        topLeft.add(pubDayField);
        topLeft.add(pubButton);

        /***********************************
        * Top Right Section (subscribers)
        ***********************************/
        //Declare the elements
        JPanel topRight = new JPanel(new GridLayout(4,2));
        JTextField subUsernameField = new JTextField("", 10);
        JTextField subCuisineField = new JTextField("", 10);
        JRadioButton radioButton1 = new JRadioButton("Daily");
        JRadioButton radioButton2 = new JRadioButton("Weekly");
        ButtonGroup group = new ButtonGroup();
        JButton subButton = new JButton("Subscribe");
        // Pass the parameters to the button when clicked
        subButton.addActionListener(e -> subButtonAction(e,
        		subUsernameField.getText(),
        		subCuisineField.getText(),
        		radioButton1,
        		radioButton2,
        		bottomTextArea));
        
        // Add the elements in order to the panel
        topRight.add(new JLabel("Username:"));
        topRight.add(subUsernameField);
        topRight.add(new JLabel("Cuisine of interest:"));
        topRight.add(subCuisineField);
        group.add(radioButton1);
        group.add(radioButton2);
        topRight.add(radioButton1);
        topRight.add(radioButton2);
        radioButton1.setSelected(true);
        topRight.add(subButton);

        /*************************************
         * Add finished panels to the window
         ************************************/
        topPanel.add(topLeft);
        topPanel.add(topRight);
        frame.add(topPanel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    /*
     * Placeholder publisher button action
     * Right now it just sends the strings to the bottomTextArea
     * with formatting.
     */
    private static void pubButtonAction(ActionEvent e, String username, String cuisine, String meal, String time, String day, JTextArea bottomTextArea) {
    	bottomTextArea.append("+++ Publish Event +++" + "\n");
        bottomTextArea.append("Username: " + username + "\n");
        bottomTextArea.append("Cuisine: " + cuisine + "\n");
        bottomTextArea.append("Meal Name: " + meal + "\n");
        bottomTextArea.append("Time of Meal: " + time + "\n");
        bottomTextArea.append("Day of Meal: " + day + "\n");
        bottomTextArea.append("\n");
    }
    
    /*
     * Placeholder subscriber button action
     * Right now it converts the radio button selection to a string
     * then sends all the strings to the bottonTextArea
     * with formatting.
     */
    private static void subButtonAction(ActionEvent e, String username, String cuisine, JRadioButton dailyButton, JRadioButton weeklyButton, JTextArea bottomTextArea) {
        String subscription = dailyButton.isSelected() ? "Daily" : "Weekly";
        bottomTextArea.append("+++ Subscribe Event +++" + "\n");
        bottomTextArea.append("Username: " + username + "\n");
        bottomTextArea.append("Cuisine: " + cuisine + "\n");
        bottomTextArea.append("Subscription type: " + subscription + "\n");
        bottomTextArea.append("\n");
    }
}
