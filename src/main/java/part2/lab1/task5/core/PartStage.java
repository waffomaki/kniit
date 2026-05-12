package part2.lab1.task5.core;

public enum PartStage {
    RAW("Заготовка"),
    ASSEMBLED("Собрана"),
    QC_PASSED("Проверена"),
    IN_WAREHOUSE("На складе");

    private final String description;

    PartStage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}