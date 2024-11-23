/**
 * Клас Cucumber наслідує усі методи класу Vegetable, тобто є його підкласом.
 * Клас Cucumber представляє огірок. Містить інформацію про вагу огірка та його калорійність.
 *
 * @author Dmytro Lutsenko
 */
public class Cucumber extends Vegetable{
    /**
     * Конструктор класу створює екземпляр класу Cucumber із заданою вагою.
     *
     * @param weight вага огірка у грамах
     */
    public Cucumber(double weight){
        super("Огірок", weight, 15.8);
    }
}
