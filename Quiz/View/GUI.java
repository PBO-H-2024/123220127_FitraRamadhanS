package View;
import javax.swing.*;

public class GUI extends JFrame{

    JLabel labelName = new JLabel("Full Name");
    JTextField nameTextField = new JTextField();

    JLabel labelNIM = new JLabel("NIM");
    JTextField nimTextField = new JTextField();

    JLabel labelDivision = new JLabel("Division");
    JRadioButton radioWeb = new JRadioButton("Web Developer");
    JRadioButton radioMobile = new JRadioButton("Mobile Developer");

    JLabel labelWriting = new JLabel("Writing Test");
    JLabel labelCoding = new JLabel("Coding Test");
    JLabel labelInterview = new JLabel("Interview Test");

    JTextField writingTextField = new JTextField();
    JTextField codingTextField = new JTextField();
    JTextField interviewTextField = new JTextField();  
    
    JLabel labelResult = new JLabel("Result : ");
    JTextField resultTextField = new JTextField();

    public JButton submitButton = new JButton("Submit");

    public GUI(){
        setTitle("GUI Scoring Application");
        setSize(500, 500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(labelName);
        add(nameTextField);
        add(nimTextField);
        add(labelNIM);
        add(labelDivision);
        add(radioWeb);
        add(radioMobile);
        add(labelWriting);
        add(labelCoding);
        add(labelInterview);
        add(writingTextField);
        add(codingTextField);
        add(interviewTextField);
        add(labelResult);
        add(resultTextField);
        add(submitButton);

        ButtonGroup divisionGroup = new ButtonGroup();
        divisionGroup.add(radioMobile);
        divisionGroup.add(radioWeb); 

        labelName.setBounds(10, 10, 120, 20);
        nameTextField.setBounds(10, 30, 100, 20);

        labelNIM.setBounds(10, 50, 120, 20);
        nimTextField.setBounds(10, 70, 100, 20);

        labelDivision.setBounds(10 , 90, 120, 20);
        radioWeb.setBounds(10, 110, 150, 15);
        radioMobile.setBounds(10, 125, 150, 15);

        labelWriting.setBounds(200, 10, 120, 20);
        writingTextField.setBounds(200, 30, 100, 15);

        labelCoding.setBounds(200, 45, 120, 20);
        codingTextField.setBounds(200, 65, 100, 15);

        labelInterview.setBounds(200, 80, 120, 20);
        interviewTextField.setBounds(200, 100, 100, 15);

        submitButton.setBounds(160, 120, 100, 20);

        labelResult.setBounds(100, 150, 50, 20);
        resultTextField.setBounds(160, 150, 200, 20);
    }

    public JTextField getNameTextField(){
        return nameTextField;
    }

    public JTextField getNIMTextField(){
        return nimTextField;
    }

    public JRadioButton getRadioMobile(){
        return radioMobile;
    }

    public JRadioButton getRadioWeb(){
        return radioWeb;
    }

    public JTextField getWritingTextField(){
        return writingTextField;
    }

    public JTextField getCodingTextField(){
        return codingTextField;
    }

    public JTextField getInterviewTextField(){
        return interviewTextField;
    }

    public void setResultTextField(String result){
        resultTextField.setText(result);
    }
    
}
