public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11 ; // psfd
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos=yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos=p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos) + (yyPos-p.yyPos)*(yyPos-p.yyPos));
    }
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        return G*p.mass*mass/(r*r);
    }
    public double calcForceExertedByX(Planet p){
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);
        return f * (p.xxPos-xxPos)/r;
    }   
    public double calcForceExertedByY(Planet p){
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);
        return f *(p.yyPos-yyPos)/r;
    }
    public double calcNetForceExertedByX(Planet[] ps){
        double totalF = 0;
        for(Planet p : ps){
            if(this.equals(p)) continue;
            totalF += calcForceExertedByX(p);
        }
        return totalF;
    }
    public double calcNetForceExertedByY(Planet[] ps){
        double totalF = 0;
        for(Planet p : ps){
            if(this.equals(p)) continue;
            totalF += calcForceExertedByY(p);
        }
        return totalF;
    }
    public void update(double dt, double fx, double fy){
        double ax = fx / mass;
        double ay = fy/mass;
        xxVel = xxVel + ax * dt;
        yyVel = yyVel + ay * dt;
        xxPos = xxVel * dt + xxPos;
        yyPos = yyVel * dt + yyPos;

    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}