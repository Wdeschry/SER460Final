package finalProject;

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
    }

    // adds the published meal to the list and calls method to notify subscribers
    public void publish(Meal meal) {
        String notification = "publish, " + meal.getPublisherName() + ", " + meal.getMealPlanType() + ", " + meal.getMealName() + ", " + meal.getCuisineType() + ", " + meal.getCookTime();

        if(meal.getMealType() != null) {
            notification += ", " + meal.getMealType();
        }
        if(meal.getDayOfWeek() != null) {
            notification += ", " + meal.getDayOfWeek();
        }

        System.out.println(notification);

        meals.add(meal);

        notifySubscribers(meal, notification);
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

        for(Subscriber subscriber : subscribers) {
            if(subscriber.getSubscriptions().contains(meal.getCuisineType()) || subscriber.getSubscriptions().contains(meal.getMealPlanType())) {
                subscriber.addNotification(notification);
            }
        }
    }
}
