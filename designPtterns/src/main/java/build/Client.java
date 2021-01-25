package build;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        BenzModel benzModel = new BenzModel();
        ArrayList<String> benzSequence = new ArrayList<>();
        benzSequence.add("start");
        benzSequence.add("alarm");
        benzSequence.add("engineeBoom");
        benzSequence.add("stop");
        benzModel.setSequence(benzSequence);

        benzModel.run();
    }
}
