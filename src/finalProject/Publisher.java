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

	public void newMeal(String username, String cuisine, String mealName, String time, String day, String plan, String type) {
		cuisine = cuisine.toLowerCase();
		Meal meal = null;
		switch(plan) {
			case "Idea":
				meal = new Meal(this.name, plan, mealName, cuisine, time);

			case "Daily":
				meal = new Meal(this.name, plan, mealName, cuisine, time, type);

			case "Weekly":
				meal = new Meal(this.name, plan, mealName, cuisine, time, type, day);
		}

		if(meal != null) {
			publish(meal);
			Gui.print("publish" + ", "
					+ meal.getPublisherName() + ", "
					+ meal.getMealPlanType() + ", "
					+ meal.getMealName() + ", "
					+ meal.getCuisineType() + ", "
					+ meal.getCookTime() + ", "
					+ meal.getMealType());
		}
	}

	public void publish(Meal meal) {
		broker.publish(meal);
	}

	public String getName() {
		return name;
	}
}
