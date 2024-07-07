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
			Gui.print("+++ Publish Event +++");
			Gui.print("Username: " + meal.getPublisherName());
			Gui.print("Cuisine: " + meal.getCuisineType());
			Gui.print("Meal Name: " + meal.getMealName());
			Gui.print("Cook Time: " + meal.getCookTime());
			Gui.print("Day of Meal: " + meal.getDayOfWeek());
			Gui.print("Type of plan: " + meal.getMealPlanType());
			Gui.print("Type of meal: " + meal.getMealType());
			Gui.print("\n");
		}
	}

	public void publish(Meal meal) {
		broker.publish(meal);
	}

	public String getName() {
		return name;
	}
}
