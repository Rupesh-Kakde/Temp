abstract class Pizza {

    String name;

    void prepare() {
        System.out.println(name + " is preparing...");
    }

    void bake() {
        System.out.println(name + " is baking...");
    }

    void cut() {
        System.out.println(name + " is cutting...");
    }

    void box() {
        System.out.println(name + " is boxing...");
    }
}