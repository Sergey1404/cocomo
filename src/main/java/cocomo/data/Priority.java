package cocomo.data;

public enum Priority {
    EXTRA_LOW(false, "Extra Low"),
    VERY_LOW(false, "Very Low"),
    LOW(false, "Low"),
    AVERAGE(true, "Nominal"),
    HIGH(false, "High"),
    VERY_HIGH(false, "Very High"),
    EXTRA_HIGH(false, "Extra High");

    public final boolean selected;
    public final String name;

    Priority(boolean selected, String name) {
        this.selected = selected;
        this.name = name;
    }
}
