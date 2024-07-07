package finalProject;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Placeholder subscriber class
 */
public class Subscriber {
    private final String name;
    private final Broker broker;
    private LinkedList<String> subscriptions;
    private Queue<String> notifications;

    Subscriber(Broker broker, String name) {
        this.broker = broker;
        this.name = name;
        this.subscriptions = new LinkedList<>();
        this.notifications = new LinkedList<>();
    }

    // adds subscription type to subscriptions and lets the broker know it has subscribed to something
    public void subscribe(String subscribeType) {
        subscribeType = subscribeType.trim();

        System.out.println("subscribe, " + name + " " +  subscribeType);

        if(subscriptions.contains(subscribeType)) {
            Gui.print("Error: Subscriber " + name + " is already subscribed to " + subscribeType);
        } else {
            subscriptions.add(subscribeType);
            Gui.print("+++ Subscribe Event +++");
            Gui.print("Username: " + this.name);
            //Gui.print("Cuisine: " + cuisine + "\n");
            Gui.print("Subscription type: " + subscribeType);
            Gui.print("");
        }

        broker.subscribe(this);
    }

    // removes subscription type from subscriptions and if subscriptions is empty unsubscribes itself from the broker
    public void unsubscribe(String subscribeType) {
        subscribeType = subscribeType.trim();

        System.out.println("unsubscribe, " + name + " " + subscribeType);

        if(subscriptions.contains(subscribeType)) {
            subscriptions.remove(subscribeType);
            Gui.print("+++ Unsubscribe Event +++");
            Gui.print("Username: " + this.name);
            Gui.print("Subscription type: " + subscribeType);
            Gui.print("");
        } else {
            System.out.println("Error: Subscriber " + name + " was not yet subscribed to " + subscribeType);
            Gui.print("Error: Subscriber " + name + " was not yet subscribed to " + subscribeType);
        }

        if(subscriptions.isEmpty()) {
            broker.unsubscribe(this);
        }
    }

    // adds notification to the queue and prints it
    public void addNotification(String notification) {
        notifications.add(notification);

        System.out.println(notification);
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getSubscriptions() {
        return subscriptions;
    }
}