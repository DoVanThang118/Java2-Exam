package exam.student.add;

import exam.Main;
import exam.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;

    public static ObservableList<Student> list = FXCollections.observableArrayList();
    public Text errors;

    public void createStudent(ActionEvent actionEvent) {
        try {
            errors.setVisible(false);
            int id = Integer.parseInt(txtId.getText());
            int phone = Integer.parseInt(txtPhone.getText());
            if(txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtAddress.getText().isEmpty()|| txtPhone.getText().isEmpty()){
                throw new Exception("ERROR !!!");
            }
            for (Student s: list){
                if (s.getId().equals(id))
                    throw new Exception("ERROR !!!");
            }
            list.add(new Student(id,txtName.getText(),txtAddress.getText(),phone));
            backToList(null);
        }
        catch (Exception e){
            errors.setText(e.getMessage());
            errors.setVisible(true);
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Student List");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
