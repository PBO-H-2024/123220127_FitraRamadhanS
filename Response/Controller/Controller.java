package Controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import Service.Service;

public class Controller {

    public Controller() {};
    Service service = new Service();

    public void clearButton(JButton clearButton, JTextField nameTextField, JTextField writeTextField, JTextField codingTextField, JTextField interviewTextField){
        nameTextField.setText("");
        writeTextField.setText("");
        codingTextField.setText("");
        interviewTextField.setText("");
    }

    public void addButton(String name, String path, int writing, int coding, int interview){
        service.addButton(name, path,writing, coding, interview);
    }

    public void deleteButton(String name){
        service.deleteData(name);
    }

    public void updateButton(String Oldname, String name, String path, int writing, int coding, int interview){
        service.updateData(Oldname, name, path, writing, coding, interview);
    }
}
