package week4.day_1;


//  Define an interface MealPlan
interface MealPlan {
    void displayMeal();
}

// Create concrete meal plan classes
class VegetarianMeal implements MealPlan {
    public void displayMeal() {
        System.out.println("Vegetarian Meal: Grilled Veg sandwich");
    }
}

class VeganMeal implements MealPlan {
    public void displayMeal() {
        System.out.println("Vegan Meal: vegan meals");
    }
}

class KetoMeal implements MealPlan {
    public void displayMeal() {
        System.out.println("Keto Meal: Avocado and Egg Salad");
    }
}

class HighProteinMeal implements MealPlan {
    public void displayMeal() {
        System.out.println("High Protein Meal: Grilled Chicken with Brown Rice");
    }
}

//  Implement a generic class with bounded type parameters
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void serveMeal() {
        mealPlan.displayMeal();
    }
}

//  Generic method to create a personalized meal plan
class MealFactory {
    public static <T extends MealPlan> Meal<T> createMeal(T mealPlan) {
        return new Meal<>(mealPlan);
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        // Create different meal plans
        Meal<VegetarianMeal> vegetarianMeal = MealFactory.createMeal(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealFactory.createMeal(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealFactory.createMeal(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = MealFactory.createMeal(new HighProteinMeal());

        // Serve meals
        vegetarianMeal.serveMeal();
        veganMeal.serveMeal();
        ketoMeal.serveMeal();
        highProteinMeal.serveMeal();
    }
}
