package cocomo.controllers;

import cocomo.data.Result;
import cocomo.data.cocomo.Project;
import cocomo.data.cocomo.Rating;
import cocomo.exception.MissingRequiredFieldException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;


public class CocomoFXMLController extends BasedController implements Initializable {
    @FXML
    private TextField size;
    @FXML
    private ComboBox<Project> projectType;
    @FXML
    private TableView<cocomo.data.Property> properties;

    @Override
    public Result getResult() {
        double size = Double.parseDouble(this.size.getText());
        Project project = projectType.getSelectionModel().getSelectedItem();
        Optional.ofNullable(project).orElseThrow(() -> new MissingRequiredFieldException("Выберите тип проекта"));

        double eaf = Arrays.stream(Rating.values())
                .mapToDouble(p -> (double) p.toggleGroup.getSelectedToggle().getUserData())
                .reduce(1, (a, b) -> a * b);
        double pm = eaf * project.a * Math.pow(size, project.b);
        double tm = project.c * Math.pow(pm, project.d);
        double ss = pm / tm;
        return new Result(pm, tm, ss);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectType.getItems().setAll(Project.values());
        fillTable(properties, Rating.values());
    }
}
