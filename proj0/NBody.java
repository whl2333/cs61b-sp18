public class NBody{
    public static double readRadius(String filepath){
        In in = new In(filepath);
        int num_planets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filepath){
        In in = new In(filepath);
        int num_planets = in.readInt();
        Planet[] planets = new Planet[num_planets]; 
        double radius = in.readDouble();
        int i;
        for(i=1;i<=num_planets;i++)
        {
            double xpos = in.readDouble();
            double ypos = in.readDouble();
            double xvel = in.readDouble();
            double yvel = in.readDouble();
            double mass = in.readDouble();
            String path = in.readString();
            planets[i-1] = new Planet(xpos,ypos,xvel,yvel,mass,path);
        }
        return planets;
    }

 public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);

         for(double t=0;t<=T;t+=dt)
        {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i=0;i<planets.length;i++)
            {   
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i=0;i<planets.length;i++)
            {
                planets[i].update(dt,xForces[i],yForces[i]);
            }
           
            StdDraw.picture(0,0,"images/starfield.jpg");

            for(int i=0;i<planets.length;i++)
            {
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }    

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
    
}
