package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/*
 *  Main GUI class
 *  Currently contains placeholder functionality
 */

public class Gui {
	static final JTextArea bottomTextArea = new JTextArea();
    
	public static void main(String[] args) {
    	/*****************************************************************
    	 * Placeholder for creating the pub/sub system when it is finished
    	 ****************************************************************/
    	Broker broker = new Broker();
        Subscriber subscriber = new Subscriber(broker, "Default Subscriber");
        
        //Create a set of example publishers
        LinkedList<Publisher> publishers = new LinkedList<>();
        Publisher publisher1 = new Publisher(broker, "Publisher1");
        Publisher publisher2 = new Publisher(broker, "Publisher2");
        Publisher publisher3 = new Publisher(broker, "Publisher3");
        publishers.add(publisher1);
        publishers.add(publisher2);
        publishers.add(publisher3);
        
    	
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
        //JTextArea bottomTextArea = new JTextArea();
        bottomTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bottomTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        /********************************
         * Top Left Section (publishers)
         ********************************/
        // Declare the elements
        JPanel topLeft = new JPanel(new GridLayout(8,2));
        JTextField pubUsernameField = new JTextField("", 10);
        JTextField pubCuisineField = new JTextField("", 10);
        JTextField pubMealField = new JTextField("", 10);
        JTextField pubTimeField = new JTextField("", 10);
        JTextField pubDayField = new JTextField("", 10);
        String[] planOptions = {"Idea", "Daily", "Weekly"};
        JComboBox<String> planDropdown = new JComboBox<>(planOptions);
        String[] typeOptions = {"Breakfast", "Lunch", "Dinner"};
        JComboBox<String> typeDropdown = new JComboBox<>(typeOptions);
        JButton pubButton = new JButton("Publish");
        // Pass the parameters to the button when clicked
        pubButton.addActionListener(e -> pubButtonAction(e,
        		publishers,
        		pubUsernameField.getText(),
        		pubCuisineField.getText(),
        		pubMealField.getText(),
        		pubTimeField.getText(),
        		pubDayField.getText(),
        		planDropdown.getSelectedItem().toString(),
        		typeDropdown.getSelectedItem().toString(),
        		bottomTextArea));
        
        // Add the elements in order to the panel
        topLeft.add(new JLabel("Username:"));
        topLeft.add(pubUsernameField);
        topLeft.add(new JLabel("Cuisine Type:"));
        topLeft.add(pubCuisineField);
        topLeft.add(new JLabel("Meal Name:"));
        topLeft.add(pubMealField);
        topLeft.add(new JLabel("Cook Time:"));
        topLeft.add(pubTimeField);
        topLeft.add(new JLabel("Day of Meal:"));
        topLeft.add(pubDayField);
        topLeft.add(new JLabel("Meal Plan:"));
        topLeft.add(planDropdown);
        topLeft.add(new JLabel("Meal Type:"));
        topLeft.add(typeDropdown);
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
        JRadioButton radioButton3 = new JRadioButton("Idea");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton3);
        group.add(radioButton1);
        group.add(radioButton2);
        JButton subButton = new JButton("Subscribe");
        // Pass the parameters to the button when clicked
        subButton.addActionListener(e -> subButtonAction(e,
        		subUsernameField.getText(),
        		subCuisineField.getText(),
                radioButton3,
        		radioButton1,
        		radioButton2,
        		bottomTextArea));
        
        JButton unsubButton = new JButton("Unsubscribe");
        // Pass the parameters to the button when clicked
        unsubButton.addActionListener(e -> unsubButtonAction(e,
        		subUsernameField.getText(),
        		subCuisineField.getText(),
                radioButton3,
        		radioButton1,
        		radioButton2,
        		bottomTextArea));
        
        // Add the elements in order to the panel
        topRight.add(new JLabel("Username:"));
        topRight.add(subUsernameField);

        topRight.add(new JLabel("Cuisine of interest:"));
        topRight.add(subCuisineField);

        JPanel radioPanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel radioPanelRight = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanelLeft.add(radioButton3);
        radioPanelLeft.add(radioButton1);
        topRight.add(radioPanelLeft);
        radioPanelRight.add(radioButton2);
        topRight.add(radioPanelRight);
        radioButton3.setSelected(true);

        topRight.add(subButton);
        topRight.add(unsubButton);

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
    private static void pubButtonAction(ActionEvent e, LinkedList<Publisher> publishers, String username, String cuisine, String mealName, String time, String day, String plan, String type, JTextArea bottomTextArea) {
    	Publisher pub = null;
    	for (Publisher i : publishers) {
    		if (username.equalsIgnoreCase(i.getName())) {
    			pub = i;
    			pub.newMeal(username, cuisine, mealName, time, day, plan, type);
    			return;
    		}
    	}
    	Gui.print("Unregistered Publisher");
    }
    
    /*
     * Placeholder subscriber button action
     * Right now it converts the radio button selection to a string
     * then sends all the strings to the bottonTextArea
     * with formatting.
     */
    private static void subButtonAction(ActionEvent e, String username, String cuisine, JRadioButton ideaButton, JRadioButton dailyButton, JRadioButton weeklyButton, JTextArea bottomTextArea) {
        String subscription = "Idea";
        if(dailyButton.isSelected()) {
            subscription = "Daily";
        } else if (weeklyButton.isSelected()) {
            subscription = "Weekly";
        }
        bottomTextArea.append("+++ Subscribe Event +++" + "\n");
        bottomTextArea.append("Username: " + username + "\n");
        bottomTextArea.append("Cuisine: " + cuisine + "\n");
        bottomTextArea.append("Subscription type: " + subscription + "\n");
        bottomTextArea.append("\n");
    }
    
    /*
     * Placeholder unsubscribe button action
     * Right now it converts the radio button selection to a string
     * then sends all the strings to the bottonTextArea
     * with formatting.
     */
    private static void unsubButtonAction(ActionEvent e, String username, String cuisine, JRadioButton ideaButton, JRadioButton dailyButton, JRadioButton weeklyButton, JTextArea bottomTextArea) {
        String subscription = "Idea";
        if(dailyButton.isSelected()) {
            subscription = "Daily";
        } else if (weeklyButton.isSelected()) {
            subscription = "Weekly";
        }
        bottomTextArea.append("+++ Unsubscribe Event +++" + "\n");
        bottomTextArea.append("Username: " + username + "\n");
        bottomTextArea.append("Cuisine: " + cuisine + "\n");
        bottomTextArea.append("Subscription type: " + subscription + "\n");
        bottomTextArea.append("\n");
    }
    
    static public void print(String text) {
    	Gui.bottomTextArea.append(text + "\n");
    }
}
