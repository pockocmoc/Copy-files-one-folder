package com.pockocmoc;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class MyWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;

    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextArea resultArea;
    JButton btnStart = new JButton("Старт");
    JButton btnExit = new JButton("Выход");


    public MyWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Сортировка файлов");
        setResizable(true);

        JPanel panBottom = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Введите путь к исходной папке: ");
        JLabel label2 = new JLabel("Введите путь назначения: ");
        JLabel label3 = new JLabel("Введите расширение файлов: ");
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();


        panBottom.add(label1);
        panBottom.add(textField1);
        panBottom.add(label2);
        panBottom.add(textField2);
        panBottom.add(label3);
        panBottom.add(textField3);

        btnStart.setMaximumSize(new Dimension(70, 70));
        btnExit.setMaximumSize(new Dimension(70, 70));
        Font font = new Font("Lato", Font.PLAIN, 20);
        btnStart.setFont(font);
        btnExit.setFont(font);
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        resultArea = new JTextArea();

        add(panBottom, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        scrollPane.setPreferredSize(new Dimension(700, 223));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.SOUTH);

        Map map = new Map();
        add(map);

        btnExit.addActionListener(e -> System.exit(0));

        btnStart.addActionListener(e -> {
            CopyFiles.copyFiles(textField1.getText(), textField2.getText(), textField3.getText(), resultArea);
            resultArea.append("Операция завершена.\n");
        });

        setVisible(true);
    }

}