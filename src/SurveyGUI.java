import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SurveyGUI {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */
        //Global variables or objects needed

        ArrayList<Participant> participants = new ArrayList<>();
        int youngest = Integer.MAX_VALUE, eldest = 0;

        do{
            String join = JOptionPane.showInputDialog(SurveyQuestions.askToJoin);

            if(join.toUpperCase().startsWith("Y")){

                Participant.addParticipants();

                //Ask your questions to get name, age and gender
                String name = JOptionPane.showInputDialog(SurveyQuestions.askName);

                String ageQuestion = JOptionPane.showInputDialog(SurveyQuestions.askAge);
                //System.out.println(SurveyQuestions.askAge);
                //int age = inputReader.nextInt();
                int age = Integer.parseInt(ageQuestion);


                String gender = JOptionPane.showInputDialog(SurveyQuestions.askGender);
                //String gender = inputReader.next();

                Participant participant = new Participant(name, age, gender);
                participants.add(participant);

                if(gender.toUpperCase().startsWith("M")) Participant.addMaleParticipants();
                else Participant.addFemaleParticipants();
            }
        }while(Participant.totalNumberOfParticipants < 3);

        for (Participant participant : participants) {

            if (participant.age >eldest) eldest = participant.age;
            if (participant.age < youngest) youngest = participant.age;
        }
        JOptionPane.showMessageDialog(null,participants);
        JOptionPane.showMessageDialog(null,"The total number of male participants is = "+Participant.totalNumberOfMaleParticipants);
        JOptionPane.showMessageDialog(null,"The total number of female participants is = "+Participant.totalNumberOfFemaleParticipants);
        JOptionPane.showMessageDialog(null,"The age of the youngest person is = "+ youngest);
        JOptionPane.showMessageDialog(null,"The age of the eldest person is = "+eldest);
        JOptionPane.showMessageDialog(null, "Thank you for participating. \nYou are AWESOME!!!");



    }
}
