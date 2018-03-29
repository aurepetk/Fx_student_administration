package sample;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, Integer> id;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> surname;

    @FXML
    private TableColumn<Student, String> phone;

    @FXML
    private TableColumn<Student, String> email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        phone.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));

        createDummyData();

        Connection connection = MyDataBaseConnectionHandler.getConnection();
        if (connection != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prisijungeme sekmingai prie musu DB");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Prisijungti nepavyko");
            alert.show();
        }
    }

    private void pullDataFromDb(Connection connection) {
        if (connection != null) {
            try {
                Statement st = connection.createStatement();

                ResultSet resultSet = st.executeQuery("SELECT * FROM students");

                List<Student> students = new ArrayList<>();

                while (resultSet.next()) {
                    students.add(new Student(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("surname"), resultSet.getString("phone"),
                            resultSet.getString("email")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

/*    private void createDummyData(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Aurelija", "Petkeviciute", "+37067823357", "aure@gmail.com"));
        students.add(new Student(2, "Petras", "Petkevicius", "+37043567235", "petriux@gmail.com"));
        students.add(new Student(3, "Masteris", "Valdovas", "+37066600777", "kingoftheworld@sky.com"));
        ObservableList<Student> mockStudents = FXCollections.observableList(students);
        table.setItems(mockStudents);
    }*/
}
