import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CameraClient {
    private static final String HOST = "localhost"; // change for actual IP
    private static final int PORT = 6000;

    private static int type = 0;

    public static String videoPath = "";
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Camera Client");
        JLabel label = new JLabel("aaaaaa");
        frame.add(label);
        frame.setSize(640, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start Camera");
        JButton startVideo = new JButton("Start Video");
        JButton stopButton = new JButton("Notification");
        JButton locationButton = new JButton("Location");
        JButton playButton = new JButton("Play Video");
        JButton autoCameraButton = new JButton("Auto Camera(5s)");
        JButton shareMsgButton = new JButton("Share Message");

        startButton.addActionListener(e -> {
            sendCommand("action=ACTION_IMAGE_CAPTURE");
            type = 1;
        });
        startVideo.addActionListener(e -> {
            sendCommand("action=ACTION_VIDEO_CAPTURE");
            type = 2;
        });
        stopButton.addActionListener(e -> {
            sendCommand("action=ACTION_CREATE_NOTIFICATION&name=test&description=test22");
            type = 3;
        });
        locationButton.addActionListener(e -> {
            sendCommand("action=ACTION_GET_LOCATION");
            type = 4;
        });

        playButton.addActionListener(e -> {
            sendCommand("action=ACTION_PLAY_VIDEO&video_url=" + videoPath);
            type = 5;
        });

        autoCameraButton.addActionListener(e -> {
            sendCommand("action=ACTION_IMAGE_CAPTURE&auto_time=5000");
            type = 6;
        });

        shareMsgButton.addActionListener(e -> {
            sendCommand("action=ACTION_SHARE_MESSAGE&title=Test&body=share message to app");
            type = 7;
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3)); // 每行3个按钮，行数自动计算
        panel.add(startButton);
        panel.add(startVideo);
        panel.add(stopButton);
        panel.add(locationButton);
        panel.add(playButton);
        panel.add(autoCameraButton);
        panel.add(shareMsgButton);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);

        new Thread(() -> {
            try {
                MulticastSocket socket = new MulticastSocket(5000);
                InetAddress group = InetAddress.getByName("224.0.0.1");
                socket.joinGroup(group);

                byte[] buffer = new byte[65536];
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    if (type == 1 || type == 6) {
                        ByteArrayInputStream bis = new ByteArrayInputStream(packet.getData());
                        BufferedImage image = ImageIO.read(bis);
                        if (image != null) {
                            System.out.println("Received image: " + image.getWidth() + "x" + image.getHeight());
                            updateLabelIcon(label, image);
                        }
                    } else if (type == 2 || type == 3 || type == 4) {
                        SwingUtilities.invokeLater(() -> {
                            if (type == 2) {
                                videoPath = new String(packet.getData(), StandardCharsets.UTF_8);
                            }
                            label.setText(new String(packet.getData(), StandardCharsets.UTF_8));
                            label.repaint();
                        });
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void sendCommand(String command) {
        try (Socket socket = new Socket(HOST, PORT);
             OutputStream out = socket.getOutputStream()) {
            out.write(command.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateLabelIcon(JLabel label, BufferedImage image) {
        SwingUtilities.invokeLater(() -> {
            label.setText("22222");
            label.setIcon(new ImageIcon(image));
            label.repaint();
        });
    }
}

