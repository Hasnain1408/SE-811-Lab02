package edu.cmu.hcii.paint;

import java.awt.*;

public class LinePaint extends PaintObject {

    private Point startPoint;
    private Point endPoint;

    public void define(Point[] points) {

        if(points == null || points.length == 0) {
            startPoint = new Point(0, 0);
            endPoint = new Point(0, 0);
            return;
        }

        startPoint = points[0];
        endPoint = points[points.length - 1];

    }

    public double getStartX() { return startPoint.getX(); }
    public double getStartY() { return startPoint.getY(); }
    public double getEndX() { return endPoint.getX(); }
    public double getEndY() { return endPoint.getY(); }

    public Rectangle getBoundingBox() {

        int minX = (int)Math.min(startPoint.getX(), endPoint.getX()) - thickness / 2;
        int minY = (int)Math.min(startPoint.getY(), endPoint.getY()) - thickness / 2;
        int maxX = (int)Math.max(startPoint.getX(), endPoint.getX()) + thickness / 2;
        int maxY = (int)Math.max(startPoint.getY(), endPoint.getY()) + thickness / 2;

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);

    }

    public void paint(Graphics2D g) {

        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(thickness));
        g.setColor(color);
        g.drawLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int)endPoint.getY());
        g.setStroke(oldStroke);

    }

}
