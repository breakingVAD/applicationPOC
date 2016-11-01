import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by juliazhang on 11/1/16.
 */
public class InstructorApplication {

    JSpinner input;

    public static void main(String[] args){
        InstructorApplication instructor = new InstructorApplication();
        instructor.createGUI();
    }

    public void createGUI(){
        JFrame frame = new JFrame("Instructor Interface");
        JPanel panel = new JPanel();
        JButton sendButton = new JButton("Send");
        SpinnerModel model = new SpinnerNumberModel(0, -100, 100, 1);
        input = new JSpinner(model);
        panel.add(input);
        panel.add(sendButton);
        frame.add(panel);
        frame.setSize(800,500);
        frame.setVisible(true);
    }

    public void sendInformation(){
        try {
            Socket serverSocket = new Socket("128.43.80.46", 4000);
            ObjectOutputStream outputStream = new ObjectOutputStream(serverSocket.getOutputStream());
            outputStream.writeObject(input.getValue());
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
