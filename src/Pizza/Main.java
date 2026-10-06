public class Main {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        System.out.println(" New York Pizza");
        nyStore.orderPizza("cheese");

        System.out.println();

        System.out.println(" Chicago Pizza");
        chicagoStore.orderPizza("cheese");
    }
}