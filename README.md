# SER460 Final
SER460 2024 Summer C

Group 5 final project

## Project Specification:

A client has hired you to build a software service to connect dietitians and nutritionists with
people who struggle to think about what meals they should make.
Dietitians and nutritionists can publish ideas for meals. Each meal can belong to a particular
cuisine type (Chinese, Italian, Brazilian, etc.) and has an expected time to finish cooking the
meal. They can also publish meals for a daily and weekly schedule. These meals include extra
information indicating if the meal is meant for breakfast, lunch, or dinner. Weekly meal ideas
also include information about which day of the week the meal is meant to be served.
When a meal plan is published, all customers subscribed to that mealPlanType or cuisineType
will be notified.
Customers can subscribe to be notified about any new recipes belonging to a category of
interest. They can also subscribe to get notifications about daily and weekly meal plan postings.
The customers may also unsubscribe from anything they were previously subscribed to, so they
will no longer receive notifications.
The names of the dietitians, nutritionists, and customers must be unique. Upper- and lowercase
letters are treated the same

Design a software system using the publisher-subscriber design pattern. (Other design patterns
may be used with the pub/sub pattern.) There must be at least three components in the design,
a publisher, a message broker, and a subscriber. The message broker handles communication
between any number of publisher and subscriber components. Publishers and subscribers
should never directly communicate with each other.

## TODOs
Submissions - All diagrams are to be submitted as .astah files:
- [ ] Create a use case diagram for the scenarios a dietitian/nutritionist and customer may experience.
- [ ] Create a class diagram of the overall software system. Must use the publisher-subscriber design pattern
- [ ] Create sequence diagrams to describe the following operations:
- What happens when there is a publish event?
- What happens when there is a subscribe event?
- What happens when there is an unsubscribe event?
- [ ] State Machine Diagram for the message broker
- [ ] PDF report BEFORE coding:
- Describe the strategies you used to create your initial diagrams.
- Show and explain your initial designs to one other person in the class. MUST include their name in the report. Describe their feedback and how you adjusted your diagrams afterward.
- For the class, sequence, and state machine diagrams, explain how the different components are meant to interact with each other.
- [ ] PDF report AFTER coding:
- Describe what challenges occurred when trying to implement the project following your initial designs.
- If your code deviates from the designs, create a new set of diagrams to show the new software structure.
- [ ] Collect and submit source code as a ZIP file
