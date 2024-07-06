package finalProject;

/*
 * Placeholder publisher class
 */
public class Publisher {
    private final String name;
    private final Broker broker;

    Publisher(Broker broker, String name) {
        this.name = name;
        this.broker = broker;
    }

    public void publish(Meal meal) {
        broker.publish(meal);
    }

    public String getName() {
        return name;
    }
}
