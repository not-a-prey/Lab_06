import java.util.ArrayList;
import java.util.List;

/**
 * Клас Main - головний клас, що складається з виконавчого методу main,
 * де виконуються перевірка методів та конструкторів класу VegetableSet.
 *
 * @author Dmytro Lutsenko
 */
public class Main {
    /**
     * Виконавчий метод, у якому йде перевірка класу VegetableSet та його методів.
     *
     * @param args значення не задані
     */
    public static void main(String[] args) {
        int c2 = 2213 % 2;
        int c3 = 2213 % 3;
        System.out.println("Інтерфейс за варіантом 2213 mod 2 = " + c2 + ": Set.\n" +
                "Внутрішня структура колекції за варіантом 2213 mod 3 = " + c3 + ": Двозв'язний список.\n");

        Cucumber cucumber50 = new Cucumber(50);
        Cucumber cucumber100 = new Cucumber(100);
        Radish radish300 = new Radish(300);
        Onion onion50 = new Onion(50);
        Tomato tomato250 = new Tomato(250);

        List<Vegetable> vegetablesForThirdSalad = new ArrayList<>();
        vegetablesForThirdSalad.add(onion50);
        vegetablesForThirdSalad.add(radish300);

        VegetableSet mySalad = new VegetableSet();
        VegetableSet mySecondSalad = new VegetableSet(tomato250);
        VegetableSet myThirdSalad = new VegetableSet(vegetablesForThirdSalad);

        mySalad.add(cucumber50);
        mySalad.add(radish300);
        mySalad.add(onion50);

        mySecondSalad.add(cucumber100);
        mySecondSalad.add(onion50);

        System.out.println("Склад колекції mySalad:");
        System.out.println(printSet(mySalad) + "\n");
        System.out.println("Розмір колекції mySalad: " + mySalad.size());
        System.out.println("Чи має вона Radish: " + mySalad.contains(new Radish(300)));
        System.out.println("Чи пуста колекція: " + mySalad.isEmpty());

        mySalad.remove(onion50);
        System.out.println("Склад колекції mySalad після видалення Onion(50):");
        System.out.println(printSet(mySalad) + "\n");

        mySalad.addAll(mySecondSalad);
        System.out.println("Розмір колекції mySalad після додавання до нього колекції mySecondSalad: " + mySalad.size());
        System.out.println("Склад колекції mySalad:");
        System.out.println(printSet(mySalad) + "\n");

    }

    /**
     * Повертає елементи колекції об'єднані в одну строку.
     *
     * @param set - колекція типу VegetableSet, елементи якої ми хочемо об'єднати
     * @return елементи колекції об'єднані в одну строку
     */
    public static String printSet(VegetableSet set) {
        StringBuilder sb = new StringBuilder();
        for (Vegetable vegetable : set) {
            sb.append(vegetable);
        }
        return sb.toString();
    }
}