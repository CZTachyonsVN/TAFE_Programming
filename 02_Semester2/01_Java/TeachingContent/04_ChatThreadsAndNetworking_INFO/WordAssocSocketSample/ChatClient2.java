package wordassociation;
//Source relating to Chat:
//  Creating a simple Chat Client/Server Solution 
//  http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html


//CHAT RELATED ---------------------------
import java.net.*;
import java.io.*;
//----------------------------------------

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SpringLayout;

public class ChatClient2 extends Frame implements ActionListener, WindowListener
{

    //CHAT RELATED ---------------------------
    private Socket socket = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    private ChatClientThread2 client2 = null;
    private String serverName = "localhost";
    private int serverPort = 4444;
    //----------------------------------------

    Label lblWord1, lblWord2, lblMessage;
    TextField txtWord1, txtWord2;
    Button btnSend, btnExit, btnConnect;
    

    public static void main(String[] args)
    {
        Frame myFrame = new ChatClient2();
        myFrame.setSize(470, 170);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);

    }

    public ChatClient2()
    {
        setTitle("Word Association Socket Sample - Client 2");
        setBackground(Color.green);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);

        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateButtons(myLayout);

        this.addWindowListener(this);
        
        //CHAT RELATED ---------------------------
        getParameters(); 
        //----------------------------------------
    }

//<editor-fold defaultstate="collapsed" desc="GUI Construction">
    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblWord1 = LocateALabel(myLabelLayout, lblWord1, "Word 1: ", 30, 25);
        lblWord2 = LocateALabel(myLabelLayout, lblWord2, "Word 2: ", 30, 50);
        lblMessage = LocateALabel(myLabelLayout, lblMessage, "---------------------------------------------------------------------", 30, 75);
    }

    public Label LocateALabel(SpringLayout myLabelLayout, Label myLabel, String LabelCaption, int x, int y)
    {
        myLabel = new Label(LabelCaption);
        add(myLabel);
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, this);
        return myLabel;
    }

    public void LocateTextFields(SpringLayout myTextFieldLayout)
    {
        txtWord1 = LocateATextField(myTextFieldLayout, txtWord1, 20, 130, 25);
        txtWord2 = LocateATextField(myTextFieldLayout, txtWord2, 20, 130, 50);
    }

    public TextField LocateATextField(SpringLayout myTextFieldLayout, TextField myTextField, int width, int x, int y)
    {
        myTextField = new TextField(width);
        add(myTextField);
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, this);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, this);
        return myTextField;
    }

    public void LocateButtons(SpringLayout myButtonLayout)
    {
        btnConnect = LocateAButton(myButtonLayout, btnConnect, "Connect", 320, 25, 80, 25);
        btnSend = LocateAButton(myButtonLayout, btnSend, "Send", 320, 50, 80, 25);
        btnExit = LocateAButton(myButtonLayout, btnExit, "Exit", 320, 75, 80, 25);
    }

    public Button LocateAButton(SpringLayout myButtonLayout, Button myButton, String ButtonCaption, int x, int y, int w, int h)
    {
        myButton = new Button(ButtonCaption);
        add(myButton);
        myButton.addActionListener(this);
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, this);
        myButton.setPreferredSize(new Dimension(w, h));
        return myButton;
    }
//</editor-fold>

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnSend)
        {
            send();
            txtWord1.requestFocus();
        }

        if (e.getSource() == btnExit)
        {
            txtWord1.setText(".bye");
            txtWord2.setText("");
            send();
            System.exit(0);
        }

        if (e.getSource() == btnConnect)
        {
            connect(serverName, serverPort);
        }
    }

    public void connect(String serverName, int serverPort)
    {
        println("Establishing connection. Please wait ...");
        try
        {
            socket = new Socket(serverName, serverPort);
            println("Connected: " + socket);
            open();
        }
        catch (UnknownHostException uhe)
        {
            println("Host unknown: " + uhe.getMessage());
        }
        catch (IOException ioe)
        {
            println("Unexpected exception: " + ioe.getMessage());
        }
    }

    private void send()
    {
        try
        {
            streamOut.writeUTF(txtWord1.getText());
            streamOut.flush();
            txtWord1.setText("");
        }
        catch (IOException ioe)
        {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }

    public void handle(String msg)
    {
        if (msg.equals(".bye"))
        {
            println("Good bye. Press EXIT button to exit ...");
            close();
        }
        else
        {
            System.out.println("Handle: " + msg);
            println(msg);
        }
    }

    public void open()
    {
        try
        {
            streamOut = new DataOutputStream(socket.getOutputStream());
            client2 = new ChatClientThread2(this, socket);
        }
        catch (IOException ioe)
        {
            println("Error opening output stream: " + ioe);
        }
    }

    public void close()
    {
        try
        {
            if (streamOut != null)
            {
                streamOut.close();
            }
            if (socket != null)
            {
                socket.close();
            }
        }
        catch (IOException ioe)
        {
            println("Error closing ...");
        }
        client2.close();
        client2.stop();
    }

    void println(String msg)
    {
        //display.appendText(msg + "\n");
        lblMessage.setText(msg);
    }

    public void getParameters()
    {
//        serverName = getParameter("host");
//        serverPort = Integer.parseInt(getParameter("port"));
        
        serverName = "localhost";
        serverPort = 4444;        
    }


//<editor-fold defaultstate="collapsed" desc="WindowListener">
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }

    public void windowIconified(WindowEvent we)
    {
    }

    public void windowOpened(WindowEvent we)
    {
    }

    public void windowClosed(WindowEvent we)
    {
    }

    public void windowDeiconified(WindowEvent we)
    {
    }

    public void windowActivated(WindowEvent we)
    {
    }

    public void windowDeactivated(WindowEvent we)
    {
    }

//</editor-fold>
}
