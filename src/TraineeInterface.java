import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TraineeInterface {

    Object objFromInstructor;

    public static void main(String[] args) {
        TraineeInterface trainee = new TraineeInterface();
        trainee.createGUI();
    }

    public void createGUI(){
        JFrame frame = new JFrame("Instructor Interface");
        JPanel panel = new JPanel();
        getInformation();
        JLabel label1 = new JLabel(objFromInstructor.getValue()); //need to have a getValue function
        panel.add(label1);
        frame.add(panel);
        frame.setSize(800,500);
        frame.setVisible(true);
    }

    public void getInformation(){
        try {
            Socket clientSocket = new Socket("128.42.82.43", 4000);
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
            objFromInstructor = inputStream.readObject();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}