package edu.cmu.hcii.paint;

public class TestPaint {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintWindow(400, 300);
            }
        });
    }

}
