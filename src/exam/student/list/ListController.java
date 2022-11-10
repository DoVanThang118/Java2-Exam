package exam.student.list;

import exam.Main;
import exam.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static exam.student.add.AddController.list;

public class ListController implements Initializable {

    public TableView<Student> tbStudent;
    public TableColumn<Student,Integer> tcId;
    public TableColumn<Student,String> tcName;
    public TableColumn<Student,String> tcAddress;
    public TableColumn<Student,Integer> tcPhone;
    public TableColumn<Student, Button> tcAction;

    public void goToAdd(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../add/add.fxml"));
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(new Student(12,"asd","asda",123123123));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("action"));
        tbStudent.setItems(list);
    }
}
