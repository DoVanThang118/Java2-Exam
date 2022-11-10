package exam;

import exam.student.edit.EditController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Student {
    public Integer id;
    public String name;
    public String address;
    public Integer phone;
    public Button action;


    public Student(Integer id, String name, String address, Integer phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.action = new Button("Action");
        this.action.setOnAction(event -> {
            try {
                EditController.editItem = this;
                Parent listBook = FXMLLoader.load(getClass().getResource("../edit/edit.fxml"));
                Main.rootStage.setTitle("Edit Student");
                Main.rootStage.setScene(new Scene(listBook,800,600));
            }catch (Exception e){
                System.out.println("ERROR");
            }
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }
}
