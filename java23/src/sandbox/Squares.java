package sandbox;

import graphicsLib.G;
import graphicsLib.Window;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Squares extends Window {
    public static G.VS vs = new G.VS(100, 200, 200, 100);
    public static Color color = Color.BLUE;
    public static Square.List list = new Square.List();
    public static Square square;

    public Squares(){super("Squares", 1000, 700);}

    @Override
    public void paintComponent(Graphics g){
        G.fillBack(g);
        g.setColor(color);
        //g.fillRect(100, 100, 100, 100);
        vs.fill(g);
        list.draw(g);
    }
    @Override
    public void mousePressed(MouseEvent me){
        int x = me.getX(), y = me.getY();
        if(vs.hit(x, y)){
            color = G.rndColor();
        } else{
            list.addNew(x,y);
            square = list.get(list.size() -1);
        }

        repaint();
    }
    @Override
    public void mouseDragged(MouseEvent me){
        if(square != null){square.resize(me.getX(), me.getY());}
        repaint();
    }

    // ----------- Square ---------------
    public static class Square extends G.VS{
        public Color c = G.rndColor();
        public Square(int x, int y){ super(x, y, 100, 100);}
        public void resize(int x, int y){if(x > loc.x && y > loc.y) {size.x = x - loc.x; size.y = y - loc.y;}}

        // ---------- List ------------
        public static class List extends ArrayList<Square> {
            public void draw(Graphics g){for(Square s: this){g.setColor(s.c);s.fill(g);}}
            public void addNew(int x, int y){add(new Square(x,y));}
        }
    }
    public static void main(String [] args){
        PANEL = new Squares();
        Window.launch();
    }
}
