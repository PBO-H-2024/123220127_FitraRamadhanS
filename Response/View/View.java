package View;

import javax.swing.*;

import Controller.Controller;
import Model.Model;
import Service.Service;
import java.awt.event.MouseAdapter;



public class View {

    final String[] tableHeader = {"Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"};

    JFrame window = new JFrame("123220127 / Fita Ramadhan / Response");

    JLabel nameLabel = new JLabel("Name");
    JTextField nameTextField = new JTextField();

    JLabel pathLabel = new JLabel("Path");
    String[] pathChoice = {"Android Dev", "Web Developer"};
    JComboBox<String> pathBox = new JComboBox<String>(pathChoice);

    JLabel writingLabel = new JLabel("Writing");
    JTextField writingTextField = new JTextField();

    JLabel codingLabel = new JLabel("Coding");
    JTextField codingTextField = new JTextField();

    JLabel interviewLabel = new JLabel("Interview");
    JTextField interviewTextField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");

    JTable tableData;
    Controller controller = new Controller();

    int row;

    public View(){
        window.setLayout(null);
        window.setSize(750, 400);
        window.setVisible(true);
        window.setLocationRelativeTo(null);

        Service connection = new Service();
        connection.readData();

        String[][] data = new String[Model.listRecruit.length][7];
        data[0] = tableHeader;
        for (int i = 0; i < Model.listRecruit.length; i++) {
            if (Model.listRecruit[i] != null) {
                data[i+1][0] = Model.listRecruit[i].name;
                data[i+1][1] = Model.listRecruit[i].path;
                data[i+1][2] = Integer.toString(Model.listRecruit[i].writing);
                data[i+1][3] = Integer.toString(Model.listRecruit[i].coding);
                data[i+1][4] = Integer.toString(Model.listRecruit[i].interview);
                data[i+1][5] = Integer.toString(Model.listRecruit[i].score);
                data[i+1][6] = Model.listRecruit[i].result;
            }
        }

        tableData = new JTable(data, tableHeader);

        addComponents();
        setBounds();
        buttonFunction();
    }

    private void addComponents(){
        window.add(nameLabel);
        window.add(nameTextField);

        window.add(pathLabel);
        window.add(pathBox);

        window.add(writingLabel);
        window.add(writingTextField);

        window.add(codingLabel);
        window.add(codingTextField);

        window.add(interviewLabel);
        window.add(interviewTextField);

        window.add(addButton);
        window.add(updateButton);
        window.add(deleteButton);
        window.add(clearButton);

        window.add(tableData);
    }

    private void setBounds(){
        nameLabel.setBounds(600, 10, 100, 15);
        nameTextField.setBounds(600, 25, 100, 20);

        pathLabel.setBounds(600, 45, 100, 15);
        pathBox.setBounds(600, 60, 100, 20);

        writingLabel.setBounds(600, 80, 100, 15);
        writingTextField.setBounds(600, 95, 100, 20);

        codingLabel.setBounds(600, 115, 100, 15);
        codingTextField.setBounds(600, 130, 100, 20);

        interviewLabel.setBounds(600, 150, 100, 15);
        interviewTextField.setBounds(600, 165, 100, 20);

        addButton.setBounds(600, 200, 100, 20);
        updateButton.setBounds(600, 230, 100, 20);
        deleteButton.setBounds(600, 260, 100, 20);
        clearButton.setBounds(600, 290, 100, 20);

        tableData.setBounds(20, 10, 500, 300);
    }

    public void buttonFunction(){
        clearButton.addActionListener( e -> {
            controller.clearButton(clearButton, nameTextField, nameTextField, codingTextField, interviewTextField);
        });

        addButton.addActionListener( e -> {
            controller.addButton(nameTextField.getText(), pathBox.getSelectedItem().toString(), Integer.parseInt(writingTextField.getText()), Integer.parseInt(codingTextField.getText()), Integer.parseInt(interviewTextField.getText()));
            window.dispose();
            new View();
        });

        tableData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);

                row = tableData.getSelectedRow();
            }
        });

        deleteButton.addActionListener(e -> {
            String name = tableData.getValueAt(row, 0).toString();
            controller.deleteButton(name);

            System.out.println(name);

            window.dispose();
            new View();
        });

        updateButton.addActionListener(e -> {
            String name = tableData.getValueAt(row, 0).toString();
            controller.updateButton(name, nameTextField.getText(), pathBox.getSelectedItem().toString(), Integer.parseInt(writingTextField.getText()), Integer.parseInt(codingTextField.getText()), Integer.parseInt(interviewTextField.getText()));

            window.dispose();
            new View();
        });
    }
}
