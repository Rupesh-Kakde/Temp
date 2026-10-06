class ChicagoPizzaStore extends PizzaStore {

    Pizza createPizza(String type) {

        if (type.equalsIgnoreCase("cheese")) {
            return new ChicagoStyleCheesePizza();
        }

        return null;
    }
}