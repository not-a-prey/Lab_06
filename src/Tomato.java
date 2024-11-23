/**
 * Клас Tomato наслідує усі методи класу Vegetable, тобто є його підкласом.
 * Клас Tomato представляє помідор. Містить інформацію про вагу помідора та його калорійність.
 *
 * @author Dmytro Lutsenko
 */
public class Tomato extends Vegetable{
    /**
     * Конструктор класу створює екземпляр класу Tomato із заданою вагою.
     *
     * @param weight вага помідора у грамах
     */
    public Tomato(double weight){
        super("Помідор", weight, 20);
    }
}
