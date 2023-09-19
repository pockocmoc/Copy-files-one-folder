package com.pockocmoc;

import javax.swing.*;

import javax.swing.JFrame;
import java.awt.*;

public class MyWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 112;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;

    private JTextField textField1;
    private JTextField textField2;


    JButton btnStart = new JButton("Старт");
    JButton btnExit = new JButton("Выход");


    MyWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Сортировка файлов");
        setResizable(false);

        JPanel panBottom = new JPanel(new GridLayout(3, 2));
        JLabel label1 = new JLabel("Введите путь к папке: ");
        JLabel label2 = new JLabel("Введите расширение файлов: ");
        textField1 = new JTextField();
        textField2 = new JTextField();
//        textField1.setBackground(Color.DARK_GRAY);
//        textField1.setForeground(Color.WHITE);
//        btnStart.setBackground(Color.DARK_GRAY);
//        btnStart.setForeground(Color.WHITE);
//        btnExit.setBackground(Color.DARK_GRAY);
//        btnExit.setForeground(Color.WHITE);
        panBottom.add(label1);
        panBottom.add(textField1);
        panBottom.add(label2);
        panBottom.add(textField2);
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.NORTH);
        Map map = new Map();
        add(map);

        setVisible(true);
    }

}