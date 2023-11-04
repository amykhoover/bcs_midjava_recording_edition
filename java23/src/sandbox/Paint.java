package sandbox;


import graphicsLib.Window;
import graphicsLib.G;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Paint extends Window {

    public static int count = 0;
    public static Path path = new Path(); //Starts out empty
    public static Pic pic = new Pic();

    public Paint(){
        super("Paint", 1000, 700);
    }

    @Override
    public void paintComponent(Graphics g){
        G.fillBack(g);
        g.setColor(Color.RED);
        //g.fillRect(100, 100, 100, 100);
        //g.fillOval(100, 100, 100, 100);
        //g.fillOval(100, 100, 200, 100);
        //g.drawOval(100, 100, 200, 100);
        g.drawRect(100, 100, 200, 100);
        g.drawLine(100,300, 400, 200);
        String msg = "Good afternoon!";
        int x = 400,y = 480;
        g.drawString(msg, x, y);
        g.setColor(Color.BLACK);
        g.fillOval(x - 1, y - 1, 2, 2);
        FontMetrics fm = g.getFontMetrics();
        int a = fm.getAscent(); // Difference between baseline and top of chars
        int d = fm.getDescent(); //Difference between baseline and bottom of chars - fontsize is a+ d
        int w = fm.stringWidth(msg);
        g.drawRect(x, y - a, w, a + d);

        g.setColor(G.rndColor());
        g.fillRect(300, 300, 100, 100);
        g.drawString("count: " + count, 100, 500);
        pic.draw(g);
    }

    @Override
    public void mousePressed(MouseEvent me){
        count++;
        path = new Path();
        path.add(me.getPoint());
        pic.add(path);
        repaint();
    }

    public void mouseDragged(MouseEvent me){
        path.add(me.getPoint());
        repaint();
    }

    public void mouseReleased(MouseEvent me){
        path.add(me.getPoint());
        repaint();
    }



    public static void main(String [] args){
        PANEL = new Paint();
        Window.launch();
    }

    // --------- PATH ----------
    public static class Path extends ArrayList<Point> {
        public void draw(Graphics g){
            // n - 1 lines for n points
            for(int i = 1; i < size(); i++) {
                Point p = get(i-1), n = get(i);
                g.drawLine(p.x, p.y, n.x, n.y);
            }
        }
    }

    // ---------- PIC ------------
    public static class Pic extends ArrayList<Path>{
        public void draw(Graphics g) {for(Path p: this) { p.draw(g);}}
    }
}
