/**
 * Клас Onion наслідує усі методи класу Vegetable, тобто є його підкласом.
 * Клас Onion представляє цибулю. Містить інформацію про вагу цибулі та її калорійність.
 *
 * @author Dmytro Lutsenko
 */
public class Onion extends Vegetable{
    /**
     * Конструктор класу створює екземпляр класу Onion із заданою вагою.
     *
     * @param weight вага цибулі у грамах
     */
    public Onion(double weight){
        super("Цибуля", weight, 43.4);
    }
}
