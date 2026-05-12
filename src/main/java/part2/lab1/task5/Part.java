package part2.lab1.task5;

import part2.lab1.task5.core.PartStage;

public class Part {
    private final int id;
    private PartStage stage;

    public Part(int id) {
        this.id = id;
        this.stage = PartStage.RAW;
    }

    public int getId() {
        return id;
    }

    public PartStage getStage() {
        return stage;
    }

    public void setStage(PartStage stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Деталь #" + id + " [" + stage + "]";
    }
}