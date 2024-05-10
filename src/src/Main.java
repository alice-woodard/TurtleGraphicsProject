
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
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
        //this.about();
    }

    @Override
    public void about(){
        displayMessage("Alice Woodard");
        super.about();
    }



    StringBuilder commandSaver = new StringBuilder();

    public void processCommand(String command) {
        System.out.println("Command Entered: "+command);
        commandSaver.append(command).append("\n");
        System.out.println(commandSaver);
        String[] amount = command.split(" ");
        int value = 0;
        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        float angle1 =0;
        float angle2 =0;
        float angle3 =0;
        String cmd = amount[0];
        Color colour = new Color(value1,value2,value3);


        try {
            if (amount.length > 1) {
                if (amount.length == 2) {
                    value = Integer.parseInt(amount[1]);
                } else if (amount.length == 3) {
                    value1 = Integer.parseInt(amount[1]);
                    value2 = Integer.parseInt(amount[2]);
                } else if (amount.length == 4) {
                    value1 = Integer.parseInt(amount[1]);
                    value2 = Integer.parseInt(amount[2]);
                    value3 = Integer.parseInt(amount[3]);
                    colour = new Color(value1,value2,value3);

                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid parameter - must be a number!");
        }

        if (cmd.equals("penup")) //Lifts the pen from the canvas, so that movement does not get shown.
        {
            penUp();
        }
        else if (cmd.equals("pendown")) //Places the pen down on the canvas so movement gets shown as a drawn line.
        {
            penDown();
        }

        else if (cmd.equals("black")) //Sets the output pen colour to black.
        {
            setPenColour(Color.black);
        }
        else if (cmd.equals("green")) //Sets the output pen colour to green.
        {
            setPenColour(Color.green);
        }
        else if (cmd.equals("red")) //Sets the output pen colour to red.
        {
            setPenColour(Color.red);
        }
        else if (cmd.equals("white")) //Sets the output pen colour to white.
        {
            setPenColour(Color.white);
        }
        else if (cmd.equals("reset")) //Resets the canvas to its initial state with turtle pointing down but does not clear the display.
        {
            reset();
        }
        else if (cmd.equals("clear")) //Clears the display.
        {
            clear();
        }
        else if (cmd.equals("turnleft")) //Turn <degrees> to the left
        {
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (value >= 0 && value <= 300) {
                turnLeft(value);
            }
            else {
                System.out.println("Invalid parameter");
            }
        }
        else if (cmd.equals("turnright")) //Turn <degrees> to the right
        {
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (value >= 0 && value <= 300) {
                turnRight(value);
            } else {
                System.out.println("Invalid parameter");
            }
        }
        else if (cmd.equals("forward")) //Move forward the specified distance.
        {
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (value >= 0 && value <= 300) {
                forward(value);
            }
            else {
                System.out.println("Invalid parameter");
            }
        }
        else if (cmd.equals("backward")) //Move backwards the specified distance.
        {
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (value >= 0 && value <= 300) {
                forward((value)*-1);
            } else {
                System.out.println("Invalid parameter");
            }
        }
        else if (cmd.equals("about")){
            about();
        }
        else if (cmd.equals("square")){
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (value >= 0 && value <= 300) {
                forward(value);
                turnLeft(90);
                forward(value);
                turnLeft(90);
                forward(value);
                turnLeft(90);
                forward(value);

            }
            else {
                System.out.println("Invalid parameter");
            }
        }
        else if (cmd.equals("penwidth")){
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (value >= 0 && value <= 300) {
                setStroke(value);
            }
            else {
                System.out.println("Invalid parameter");
            }
        }
        else if (cmd.equals("triangle")){
            if (amount.length ==1) {
                System.out.println("This function needs a parameter!");
            }
            else if (amount.length ==2) {
                if (value >= 0 && value <= 300) {
                    forward(value);
                    turnLeft(120);
                    forward(value);
                    turnLeft(120);
                    forward(value);
                }

            }

            else {
                System.out.println("Invalid parameter");
            }
        }

        else if (cmd.equals("pencolour")) {
            if (amount.length == 1) {
                System.out.println("This function needs three parameters!");
            }
            else if (amount.length == 2) {
                System.out.println("This function needs three parameters!");
            }
            else if (amount.length == 3) {
                System.out.println("This function needs three parameters!");
            }
            else if (amount.length == 4)
            {
                if (value1 >= 0 && value1 <= 255 || value2 >= 0 && value2 <= 255 || value3 >= 0 && value3 <= 255)
                {
                    setPenColour(colour);
                }
                else
                {
                    System.out.println("Invalid parameter");
                }
            }
            else
            {
                System.out.println("Invalid parameter");
            }
        }

        else if (cmd.equals("savecommands")){
            try
            {
                // used https://www.w3schools.com/java/java_files_create.asp as a template for this part to help save the file
                FileWriter fileWriter = new FileWriter("savedCommands.txt");
                fileWriter.write(String.valueOf(commandSaver));
                fileWriter.close();
                System.out.println("Successfully wrote to the file.");
            }
            catch (IOException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else if (cmd.equals("loadcommands")){

            try {
                File savedCommands = new File("savedCommands.txt");
                Scanner fileReader = new Scanner(savedCommands);
                commandSaver.delete(0, 10000);
                while (fileReader.hasNextLine())
                {
                    String data = fileReader.nextLine();
                    processCommand(data);

                }
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        else if (cmd.equals("saveimage")) {
            try {
                BufferedImage image = getBufferedImage();
                File outputFile = new File("output.png");
                ImageIO.write(image, "png", outputFile);
                System.out.println("Image saved as output.png");

            } catch (IOException e) {
                System.out.println("An error occurred while saving the image.");
                e.printStackTrace();
            }
        }

        else{
            System.out.println("Unrecognized command");
        }
    }


}
