interface BeatModel {
    void beat();
}


class HeartModel {

    public void heartBeat() {
        System.out.println("Heart is Beating...");
    }
}


class HeartAdapter implements BeatModel {

    private HeartModel heart;

    public HeartAdapter(HeartModel heart) {
        this.heart = heart;
    }

    @Override
    public void beat() {
        heart.heartBeat();
    }
}

public class Q4 {

    public static void main(String[] args) {

        HeartModel heart = new HeartModel();

        BeatModel beatModel = new HeartAdapter(heart);

        beatModel.beat();
    }
}
