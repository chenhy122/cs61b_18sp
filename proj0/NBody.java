public class NBody{
    public static double readRadius(String name) {
        In in = new In(name);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String name) {
        In in = new In(name);
        int num = in.readInt();
        in.readDouble();
        Body[] result = new Body[num];
        for (int i = 0; i < num; i += 1){
            result[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return result;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);
        
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (int i = 0; i < bodies.length; i += 1){
            bodies[i].draw();
        }
        StdDraw.show();

        StdDraw.enableDoubleBuffering();
        for (double time = 0; time <= T; time += dt){
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for (int i = 0; i < bodies.length; i += 1){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i = 0; i < bodies.length; i += 1){
                bodies[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < bodies.length; i += 1){
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
            bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }
}