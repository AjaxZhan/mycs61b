public class NBody {
    public static double readRadius(String path){
        In in = new In(path);        
        int num_planet = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] ps = new Planet[number];
        for(int i=0;i<number;i++){
            double xp = in.readDouble();
            double yp = in.readDouble();
            double vx = in.readDouble();
            double vy = in.readDouble();
            double ma = in.readDouble();
            String img = in.readString();
            ps[i] = new Planet(xp,yp,vx,vy,ma,img);
        }
        return ps;
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] ps = readPlanets(filename);
        double r = readRadius(filename);
        
        //set the scale
        StdDraw.setXscale(-r,r);
        StdDraw.setYscale(-r,r);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int number = ps.length;
        while(t<=T){
            Double[] xForces = new Double[number];
            Double[] yForces = new Double[number];
            for(int i=0;i<number;i++){
                xForces[i] = ps[i].calcNetForceExertedByX(ps);
                yForces[i] = ps[i].calcNetForceExertedByY(ps);
            }
            for(int i=0;i<number;i++){
                ps[i].update(dt, xForces[i], yForces[i]);
            }
            //背景图片
            StdDraw.picture(0, 0, "images/starfield.jpg");

            //绘制星球
            for(Planet p : ps){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            
            t+=dt;
        }

        //打印数据
        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
            ps[i].yyVel, ps[i].mass, ps[i].imgFileName);   
        }



    }
}
