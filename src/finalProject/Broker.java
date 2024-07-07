package finalProject;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Placeholder broker class
 */
public class Broker {
    private LinkedList<Meal> meals;
    private LinkedList<Subscriber> subscribers; // list of subscribers who are subscribed to at least 1 thing

    Broker() {
        meals = new LinkedList<>();
        subscribers = new LinkedList<>();
        Subscriber Bill = new Subscriber(this, "bill");
        Bill.subscribe("Italian");
        Bill.subscribe("Mexican");
        Subscriber Tim = new Subscriber(this, "tim");
        Tim.subscribe("Daily");
        subscribers.add(Bill);
        subscribers.add(Tim);
    }

    // adds the published meal to the list and calls method to notify subscribers
    public void publish(Meal meal) {
        String notification = meal.getPublisherName() + ", " + meal.getMealPlanType() + ", " + meal.getMealName() + ", " + meal.getCuisineType() + ", " + meal.getCookTime();

        if(meal.getMealType() != null) {
            notification += ", " + meal.getMealType();
        }
        if(meal.getDayOfWeek() != null) {
            notification += ", " + meal.getDayOfWeek();
        }

        System.out.println(notification);

        meals.add(meal);

        if(!subscribers.isEmpty()) {
            notifySubscribers(meal, notification);
        }
    }

    // adds subscriber to the list of subscribers, subscription type is contained within subscriber object
    public void subscribe(Subscriber subscriber) {
        if(!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    // removes subscriber from list of subscribers, subscriber will call this when its subscriptions list is empty
    public void unsubscribe(Subscriber subscriber) {
        if(!subscribers.remove(subscriber)) {
            System.out.println("Error: Subscriber " + subscriber.getName() + " wasn't subscribed to anything yet");
        }
    }

    // iterates through each subscriber in the list and notifies them if they are subscribed to the same type
    public void notifySubscribers(Meal meal, String notification) {
        String usedName ="";
        ArrayList<String> alreadyNotified = new ArrayList<String>();
        for(Subscriber subscriber : subscribers) {
            if((!alreadyNotified.contains(subscriber.getName())) && (subscriber.getSubscriptions().contains(meal.getCuisineType()) || subscriber.getSubscriptions().contains(meal.getMealPlanType()))) {
                subscriber.addNotification(notification);
                alreadyNotified.add(subscriber.getName());
            }
        }
    }

    public LinkedList<Subscriber> getSubscribers(){
        return this.subscribers;
    }

    public void addSubscriber(Subscriber sub){
        this.subscribers.add(sub);
    }
}