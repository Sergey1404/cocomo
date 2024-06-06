package cocomo.data.cocomo2;

import cocomo.data.Priority;
import cocomo.data.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.ToggleGroup;

import java.util.Arrays;
import java.util.List;

public enum PostCostProperty implements Property {
    ACAP(
            "Возможности аналитика",
            1.42,
            1.29,
            1.00,
            0.85,
            0.71,
            0
    ),
    AEXP(
            "Опыт разработки приложений",
            1.22,
            1.10,
            1.00,
            0.88,
            0.81,
            0
    ),
    PCAP(
            "Возможности программиста",
            1.34,
            1.15,
            1.00,
            0.88,
            0.76,
            0
    ),
    PCON(
            "Продолжительность работы персонала",
            1.29,
            1.12,
            1.00,
            0.90,
            0.81,
            0
    ),
    PEXP(
            "Опыт работы с платформой",
            1.19,
            1.09,
            1.00,
            0.91,
            0.85,
            0
    ),
    LTEX(
            "Опыт работы с языком программирования",
            1.20,
            1.09,
            1.00,
            0.91,
            0.84,
            0
    ),
    RELY(
            "Надежность приложения",
            0.84,
            0.92,
            1.00,
            1.10,
            1.26,
            0
    ),
    DATA(
            "Размер базы данных",
            0,
            0.23,
            1.00,
            1.14,
            1.28,
            0
    ),
    CPLX(
            "Сложность приложения",
            0.73,
            0.87,
            1.00,
            1.17,
            1.34,
            1.74
    ),
    RUSE(
            "Необходимость многократности",
            0,
            0.95,
            1.00,
            1.07,
            1.15,
            1.24
    ),
    DOCU(
            "Документирование жизненного цикла",
            0.81,
            0.91,
            1.00,
            1.11,
            1.23,
            0
    ),
    TIME(
            "Ограничение времени выполнения",
            0,
            0,
            1.00,
            1.11,
            1.29,
            1.63
    ),
    STOR(
            "Ограничения памяти",
            0,
            0,
            1.00,
            1.05,
            1.17,
            1.46
    ),
    PVOL(
            "Переменность платформы",
            0,
            0.87,
            1.00,
            1.15,
            1.30,
            0
    ),
    TOOL(
            "Инструментальные средства",
            1.17,
            1.09,
            1.00,
            0.90,
            0.78,
            0
    ),
    SITE(
            "Много абонентская разработка",
            1.22,
            1.09,
            1.00,
            0.93,
            0.86,
            0.80
    ),
    SCED(
            "Необходимое время",
            1.43,
            1.14,
            1.00,
            1.00,
            1.00,
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

    PostCostProperty(String name, double veryLow,
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
    public Property[] getValues() {
        return PostCostProperty.values();
    }
}
