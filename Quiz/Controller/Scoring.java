package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.*;

public class Scoring {
    GUI scoringGUI;

    public Scoring(GUI scoringGui){

        this.scoringGUI = scoringGui;

        scoringGUI.submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    if(scoringGui.getNameTextField().getText().isEmpty()){
                        scoringGUI.setResultTextField("Please Input Your Name");
                        return;
                    }
    
                    if(scoringGUI.getNIMTextField().getText().isEmpty()){
                        scoringGui.setResultTextField("Please Input Your NIM");
                        return;
                    }
                    
                    if(!scoringGui.getRadioMobile().isSelected() && !scoringGui.getRadioWeb().isSelected()){
                        scoringGui.setResultTextField("Please Choouse Division");
                        return;
                    }
    
                    if(scoringGui.getWritingTextField().getText().isEmpty() || scoringGui.getInterviewTextField().getText().isEmpty() || scoringGui.getCodingTextField().getText().isEmpty()){
                        scoringGui.setResultTextField("Please Fill The Value");
                        return;
                    }
    
                    int writingScore = Integer.parseInt(scoringGui.getWritingTextField().getText());
                    int codingScore = Integer.parseInt(scoringGui.getCodingTextField().getText());
                    int interviewScore = Integer.parseInt(scoringGui.getInterviewTextField().getText());
    
                    double finalScore;
    
    
                    if(scoringGui.getRadioMobile().isSelected()){
                        finalScore = (writingScore * 0.2) + (codingScore * 0.5) + (interviewScore * 0.3); 
                    }else{
                        finalScore = (writingScore * 0.4) + (codingScore * 0.35) + (interviewScore * 0.25);
                    }
    
                    if(finalScore >= 85){
                        scoringGui.setResultTextField("ACCEPTED");
                    }else{
                        scoringGui.setResultTextField("NOT ACCEPTED");
                    }
                }catch(Exception error){
                    scoringGui.setResultTextField("Error Happened When Calculating");
                }
            };
        });
    }
}
