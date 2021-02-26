import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        String hostt = null;
        int porrt;
        String portt = null;
        String a;
        Socket socket = new Socket();

        a = JOptionPane.showInputDialog(null,"Do you want to start as Client?");

        if (a.equals("sim")) {
            hostt = JOptionPane.showInputDialog(null,"Enter the Server IP address");
            portt = JOptionPane.showInputDialog(null,"Enter the port number you want to connect to");
            porrt = Integer.parseInt(portt);
            System.out.println("ip =" + hostt + " e port = " + porrt);
            startClient(hostt,porrt);
            System.out.println("ip =" + hostt + " e port = " + porrt);
            //non-static method startClient(int) cannot be referenced from a static context
        } else {
            portt = JOptionPane.showInputDialog(null,"Enter a port number available for connection");
            porrt = Integer.parseInt(portt);
            startServer(porrt);
            //non-static method startServer(int) cannot be referenced from a static context
        }
    }
    private static void startClient(String host, int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port));
            chat(socket);
        } catch (UnknownHostException e) {
            System.out.println("Unrecognized host");
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.exit(2);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Standing by for connection at port " + port);
            Socket s = serverSocket.accept();
            chat(s);
        } catch (IOException e) {
            System.out.println("Communication problem: ");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void chat(Socket s) throws IOException {
        System.out.println("Connected to " + s.getRemoteSocketAddress());
        listen(s.getInputStream());
        talk(s.getOutputStream());
    }

    /**
     * @param outputStream
     */
    private static void talk(OutputStream outputStream) throws IOException {
        DataOutputStream output = new DataOutputStream(outputStream);
        String line = "";

        while (!line.equals("EXIT")) {
            Scanner scan = new Scanner(System.in);
            System.out.print(": ");
            line = scan.nextLine();
            output.writeInt(line.length());
            for (char ch : line.toCharArray())
                output.writeChar(ch);
            output.flush();
        }
    }

    /**
     * @param inputStream
     */
    private static void listen(final InputStream inputStream) {
        new Thread(new Runnable() {
            DataInputStream ds = new DataInputStream(inputStream);
            public void run() {
                try {
                    while (true) {
                        int size = ds.readInt();
                        int cont = 0;
                        char[] chars = new char[size];

                        while (cont < size) {
                            chars[cont] = ds.readChar();
                            cont = cont + 1;
                        }

                        String str = new String(chars);

                        if (str.equals("EXIT")) {
                            System.out.println("Communication with server was quit");
                            System.exit(0);
                        }

                        System.out.println(str);
                    }

                } catch (IOException e) {
                }
            }
        }).start();
    }
}
