package com.home.java2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWin extends JFrame {
    private JTextArea chatTextArea;
    private JTextField chatTextField;

    public MyWin() throws HeadlessException {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        setLayout(new BorderLayout());

        chatTextArea = new JTextArea();
        chatTextArea.setFocusable(false);
        chatTextArea.setText("Start chat ...\n");

        JScrollPane spChat = new JScrollPane(chatTextArea);
        add(spChat, BorderLayout.CENTER);

        JPanel endPanel = new JPanel();
        add(endPanel, BorderLayout.PAGE_END);
        endPanel.setLayout(new BorderLayout());

        chatTextField = new JTextField();
        endPanel.add(chatTextField, BorderLayout.CENTER);
        chatTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                messageSend();
            }
        });

        JButton sendButton = new JButton("Send");
        endPanel.add(sendButton, BorderLayout.EAST);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                messageSend();
            }
        });

        setVisible(true);
    }

    private void messageSend() {
        chatTextArea.append(chatTextField.getText() + "\n");
        chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());
        chatTextField.setText("");
    }
}
