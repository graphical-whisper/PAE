package com.mycompany.sistemapae;

import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Frame;

public class Prb {

    public static void main(String[] args) {
        Frame frame = new Frame("Ejemplo FlowLayout");
        frame.setLayout(new FlowLayout());

        Button boton1 = new Button("Botón 1");
        frame.add(boton1);

        Button boton2 = new Button("Botón 2");
        frame.add(boton2);

        Button boton3 = new Button("Botón 3");
        frame.add(boton3);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}