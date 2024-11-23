/**
 * Клас Radish наслідує усі методи класу Vegetable, тобто є його підкласом.
 * Клас Radish представляє редис. Містить інформацію про вагу редиса та його калорійність.
 *
 * @author Dmytro Lutsenko
 */
public class Radish extends Vegetable{
    /**
     * Конструктор класу створює екземпляр класу Onion із заданою вагою.
     *
     * @param weight вага цибулі у грамах
     */
    public Radish(double weight){
        super("Редис", weight, 24.1);
    }
}
