class NYPizzaStore extends PizzaStore {

    Pizza createPizza(String type) {

        if (type.equalsIgnoreCase("cheese")) {
            return new NyStyleCheesePizza();
        }

        return null;
    }
}