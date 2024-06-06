package cocomo.data.cocomo;

import cocomo.data.Priority;
import cocomo.data.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.ToggleGroup;

import java.util.Arrays;
import java.util.List;

public enum Rating implements Property {
    RELY(
            "Необходимая надежность ПО",
            0.75,
            0.88,
            1,
            1.15,
            1.4,
            0
    ),
    DATA(
            "Размер бД приложения",
            0,
            0.94,
            1,
            1.08,
            1.16,
            0
    ),
    CPLX(
            "Сложность продукта",
            0.70,
            0.85,
            1,
            1.15,
            1.30,
            1.62
    ),
    TIME(
            "Ограничение быстродействия",
            0,
            0,
            1,
            1.11,
            1.30,
            1.66
    ),
    STOR(
            "Ограничения памяти",
            0,
            0,
            1,
            1.06,
            1.21,
            0
    ),
    VIRT(
            "Неустойчивость виртуального окружения",
            0,
            0.87,
            1,
            1.15,
            1.30,
            0
    ),
    TURN(
            "Необходимое время восстановления",
            0,
            0.87,
            1,
            1.07,
            1.15,
            0
    ),
    ACAP(
            "Аналитические способности",
            1.46,
            1.19,
            1,
            0.86,
            0.71,
            0
    ),
    AEXP(
            "Опыт разработки",
            1.29,
            1.13,
            1,
            0.91,
            0.82,
            0
    ),
    PCAP(
            "Способности к разработке ПО",
            1.42,
            1.17,
            1,
            0.86,
            0.70,
            0
    ),
    VEXP(
            "Опыт использования виртуальных машин",
            1.21,
            1.10,
            1,
            0.90,
            0,
            0
    ),
    LEXP(
            "Опыт разработки на языках программирования",
            1.14,
            1.07,
            1,
            0.95,
            0,
            0
    ),
    MODP(
            "Применение методов разработки ПО",
            1.24,
            1.10,
            1,
            0.91,
            0.82,
            0
    ),
    TOOL(
            "Использование инструментария разработки",
            1.24,
            1.10,
            1,
            0.91,
            0.83,
            0
    ),
    SCED(
            "Требования соблюдения графика разработки",
            1.23,
            1.08,
            1,
            1.04,
            1.10,
            0
    );

    public final ToggleGroup toggleGroup = new ToggleGroup();
    public final SimpleStringProperty name;
    public final SimpleObjectProperty<Control> veryLow;
    public final SimpleObjectProperty<Control> low;
    public final SimpleObjectProperty<Control> average;
    public final SimpleObjectProperty<Control> high;
    public final SimpleObjectProperty<Control> veryHigh;
    public final SimpleObjectProperty<Control> critical;
    public final List<SimpleObjectProperty<Control>> priorities;

    Rating(String name, double veryLow,
           double low, double average,
           double high, double veryHigh, double critical) {
        this.name = new SimpleStringProperty(name);
        this.veryLow = new SimpleObjectProperty<>(buttonFactory(veryLow, Priority.VERY_LOW));
        this.low = new SimpleObjectProperty<>(buttonFactory(low, Priority.LOW));
        this.average = new SimpleObjectProperty<>(buttonFactory(average, Priority.AVERAGE));
        this.high = new SimpleObjectProperty<>(buttonFactory(high, Priority.HIGH));
        this.veryHigh = new SimpleObjectProperty<>(buttonFactory(veryHigh, Priority.VERY_HIGH));
        this.critical = new SimpleObjectProperty<>(buttonFactory(critical, Priority.EXTRA_HIGH));
        priorities = Arrays.asList(this.veryLow, this.low, this.average, this.high, this.veryHigh, this.critical);
    }


    @Override
    public SimpleStringProperty getName() {
        return name;
    }

    @Override
    public List<SimpleObjectProperty<Control>> getControls() {
        return priorities;
    }

    @Override
    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    @Override
    public cocomo.data.Property[] getValues() {
        return Rating.values();
    }
}
