
import java.awt.*;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.OOPGraphics;

public class Main extends OOPGraphics {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        JFrame MainFrame = new JFrame();
        MainFrame.setLayout(new FlowLayout());
        MainFrame.add(this);
        MainFrame.pack();
        MainFrame.setVisible(true);
        this.about();
    }

    public void processCommand(String command) {
        System.out.println(command);
        String[] amount = command.split("<",">");
        int value = 0;
        if (amount.length == 2) {
            command = amount[0];
            value = Integer.parseInt(amount[1]);
        }



        if (command.equals("penup")) //Lifts the pen from the canvas, so that movement does not get shown.
        {
            penUp();
        }
        else if (command.equals("pendown")) //Places the pen down on the canvas so movement gets shown as a drawn line.
        {
            penDown();
        }
        else if (command.equals("turnleft"))
        {
            turnLeft(value);
        }
        else if (command.equals("turnright")){
            turnRight(value);
        }
        else if (command.equals("forward")){
            forward(value);
        }
        else if (command.equals("backward")){
            forward((value)*-1);
        }
        else if (command.equals("black")){
            setPenColour(Color.black);
        }
        else if (command.equals("green")){
            setPenColour(Color.green);
        }
        else if (command.equals("red")){
            setPenColour(Color.red);
        }
        else if (command.equals("white")){
            setPenColour(Color.white);
        }
        else if (command.equals("reset")){
            reset();
        }
        else if (command.equals("clear")) {
            clear();
        }
        else{

        }
    }
}
