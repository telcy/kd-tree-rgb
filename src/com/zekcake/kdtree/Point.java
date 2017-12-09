package com.zekcake.kdtree;

import java.awt.*;

public class Point {

    private Color color;
    private Position position;

    Point(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }
}
