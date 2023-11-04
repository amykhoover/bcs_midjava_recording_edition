package graphicsLib;

import java.awt.*;
import java.util.Random;


public class G {
    public static Random RND = new Random();
    public static int rnd(int n){return RND.nextInt(n);}

    public static Color rndColor(){return new Color(rnd(256), rnd(256), rnd(256));}

    public static void fillBack(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,5000,5000);
    }

    // ---------- V (vector)------------
    public static class V{
        public int x,y;
        public V(int x, int y){set(x,y);}
        public V(V v){set(v.x,v.y);}
        public void set(int x, int y){this.x = x; this.y = y;}
        public void add(V v){x += v.x; y += v.y;}
    }


    // ---------- VS (rectangle - vector and size) ------------
    public static class VS{
        public V loc = new V(0,0), size = new V(0,0);
        public VS(int x, int y, int w, int h){loc.set(x,y); size.set(w,h);}
        public void fill(Graphics g){g.fillRect(loc.x, loc.y, size.x, size.y);}
        public boolean hit(int x, int y){return x > loc.x && x < (loc.x + size.x) && y > loc.y && y < (loc.y + size.y);}

    }

    // ---------- LoHi (low number and high number whose range we want) ------------
    public static class LoHi{}


    // ---------- BBox (bounding box) ------------
    public static class BBox{}

    // ---------- PL (polyline -> list of a whole bunch of coordinates) ------------
    public static class PL{}

}
