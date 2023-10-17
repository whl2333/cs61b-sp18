public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP,double yP, double xV, double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p)
    {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p)
    {
        return Math.sqrt(Math.pow((this.xxPos-p.xxPos),2)+Math.pow((this.yyPos-p.yyPos),2));
    }

    public double calcForceExertedBy(Planet p)
    {
        double d = this.calcDistance(p);
        double m1 = this.mass;
        double m2 = p.mass;
        double G = 6.67E-11;
        return G*m1*m2/Math.pow(d,2);
    }

    public double calcForceExertedByX(Planet p)
    {
        double dx = p.xxPos-this.xxPos;
        double r = this.calcDistance(p);
        double Fx = this.calcForceExertedBy(p); 
        return Fx*dx/r;
    }

    public double calcForceExertedByY(Planet p)
    {
        double dy = p.yyPos-this.yyPos;
        double r = this.calcDistance(p);
        double Fx = this.calcForceExertedBy(p); 
        return Fx*dy/r;
    }

    public double calcNetForceExertedByX(Planet[] planets)
    {
        int i;
        double netX=0;
        for(Planet planet:planets)
        {   
            if (this.equals(planet))
            {
                continue;
            }
            netX = netX + this.calcForceExertedByX(planet);
        }
        return netX;
    }

    public double calcNetForceExertedByY(Planet[] planets)
    {
        int i;
        double netY=0;
        for(Planet planet:planets)
        {   
            if (this.equals(planet))
            {
                continue;
            }
            netY = netY + this.calcForceExertedByY(planet);
        }
        return netY;
    }

    public void update(double delta_t, double netX, double netY)
    {
        double a_x = netX/this.mass;
        double a_y = netY/this.mass;

        this.xxVel = this.xxVel + a_x * delta_t;
        this.yyVel = this.yyVel + a_y * delta_t;

        this.xxPos = this.xxPos + this.xxVel * delta_t;
        this.yyPos = this.yyPos + this.yyVel * delta_t;
    }

    public void draw()
    {   
        String pictodraw = this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos,"images/" + pictodraw);
        //StdDraw.show();
    }
}
