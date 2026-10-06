import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Menu Item
class MenuItem {

    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


// Breakfast Menu
class BreakfastMenu {

    private List<MenuItem> items = new ArrayList<>();

    public BreakfastMenu() {
        addItem("Idli", 40);
        addItem("Dosa", 60);
        addItem("Poha", 30);
    }

    public void addItem(String name, double price) {
        items.add(new MenuItem(name, price));
    }

    public Iterator<MenuItem> createIterator() {
        return items.iterator();
    }
}


// Lunch Menu
class LunchMenu {

    private MenuItem[] items;
    private int numberOfItems = 0;

    public LunchMenu() {

        items = new MenuItem[6];

        addItem("Veg Thali", 120);
        addItem("Paneer Rice", 150);
        addItem("Dal Rice", 100);
    }

    public void addItem(String name, double price) {

        if (numberOfItems >= items.length) {
            System.out.println("Menu is full");
        } else {
            items[numberOfItems] =
                    new MenuItem(name, price);

            numberOfItems++;
        }
    }

    public Iterator<MenuItem> createIterator() {
        return new ArrayIterator(items, numberOfItems);
    }
}


// Dinner Menu
class DinnerMenu {

    private MenuItem[] items;
    private int numberOfItems = 0;

    public DinnerMenu() {

        items = new MenuItem[6];

        addItem("Chapati Bhaji", 100);
        addItem("Veg Biryani", 140);
        addItem("Pulao", 110);
    }

    public void addItem(String name, double price) {

        if (numberOfItems >= items.length) {
            System.out.println("Menu is full");
        } else {
            items[numberOfItems] =
                    new MenuItem(name, price);

            numberOfItems++;
        }
    }

    public Iterator<MenuItem> createIterator() {
        return new ArrayIterator(items, numberOfItems);
    }
}


// Iterator for Array
class ArrayIterator implements Iterator<MenuItem> {

    private MenuItem[] items;
    private int position = 0;
    private int size;

    public ArrayIterator(MenuItem[] items, int size) {
        this.items = items;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public MenuItem next() {
        return items[position++];
    }
}


// Waitress
class Waitress {

    private BreakfastMenu breakfastMenu;
    private LunchMenu lunchMenu;
    private DinnerMenu dinnerMenu;

    public Waitress(
            BreakfastMenu breakfastMenu,
            LunchMenu lunchMenu,
            DinnerMenu dinnerMenu) {

        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {

        System.out.println("===== BREAKFAST MENU =====");
        printMenu(breakfastMenu.createIterator());

        System.out.println("\n===== LUNCH MENU =====");
        printMenu(lunchMenu.createIterator());

        System.out.println("\n===== DINNER MENU =====");
        printMenu(dinnerMenu.createIterator());
    }

    private void printMenu(Iterator<MenuItem> iterator) {

        while (iterator.hasNext()) {

            MenuItem item = iterator.next();

            System.out.println(
                    item.getName()
                    + " - Rs."
                    + item.getPrice());
        }
    }
}


// Main Class
public class MenuIteratorDemo {

    public static void main(String[] args) {

        BreakfastMenu breakfast =
                new BreakfastMenu();

        LunchMenu lunch =
                new LunchMenu();

        DinnerMenu dinner =
                new DinnerMenu();

        Waitress waitress =
                new Waitress(
                        breakfast,
                        lunch,
                        dinner);

        waitress.printMenu();
    }
}