/**
 * Клас Vegetable є батьківським класом, який складається з полів ім'я (name), вага (weight) та калорійність (calories).
 * Клас складається з конструктора, геттерів для кожного поля, та методу getTotalCalories() - який повертає кількість
 * калорій в овочі із заданою вагою.
 *
 * @author Dmytro Lutsenko
 */
public class Vegetable {
    private String name;
    private double weight;
    private double calories;

    /**
     * Конструктор класу Vegetable
     *
     * @param name - ім'я овоча
     * @param weight - вага овоча
     * @param calories - калорійність овоча на 100 грамів
     */
    public Vegetable(String name, double weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    /**
     * Геттер, який повертає ім'я овоча
     *
     * @return ім'я овоча
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер, який повертає вагу овоча
     *
     * @return вага овоча у грамах
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Геттер, який повертає калорійність овоча
     *
     * @return кількість калорій в овочі на 100 грамів
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Метод, який повертає кількість калорій залежно від ваги овоча
     *
     * @return кількість калорій овоча залежно від ваги самого овоча
     */
    public double getTotalCalories() {
        return (weight/100)*calories;
    }

    @Override
    public String toString() {
        return name + " (" + weight + "г, " + calories + "ккал). ";
    }
}
