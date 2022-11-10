package exam.student.edit;

import exam.Main;
import exam.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;
    public Text errors;

    public static Student editItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editItem != null){
            txtId.setText(editItem.getId().toString());
            txtName.setText(editItem.getName());
            txtAddress.setText(editItem.getAddress());
            txtPhone.setText(editItem.getPhone().toString());
        }
    }

    public void updateStudent(ActionEvent actionEvent) {
        try {
            errors.setVisible(false);
            int phone = Integer.parseInt(txtPhone.getText());
            if(txtName.getText().isEmpty() || txtAddress.getText().isEmpty()|| txtPhone.getText().isEmpty()){
                throw new Exception("ERROR !!!");
            }
            editItem.setName(txtName.getText());
            editItem.setAddress(txtAddress.getText());
            editItem.setPhone(phone);
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
