public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        double distance2 = Math.pow(b.xxPos - this.xxPos, 2) + Math.pow(b.yyPos - this.yyPos, 2);
        return Math.sqrt(distance2);
    }
    /**calculate the force */
    public double calcForceExertedBy(Planet b) {
        double G = 6.67e-11;
        double distance = this.calcDistance(b);
        double Force = G * this.mass * b.mass / (distance * distance);
        return Force;
    }

    public double calcForceExertedByX(Planet b) {
        double distance = this.calcDistance(b);
        double Force = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        return Force * dx / distance;
    }

    public double calcForceExertedByY(Planet b) {
        double distance = this.calcDistance(b);
        double Force = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        return Force * dy / distance;
    }  

    /**calculate the net force */
    public double calcNetForceExertedByX(Planet[] b) {
        int num = b.length;
        double xNetForce = 0;
        for (int i = 0; i < num; i += 1){
            if (b[i].equals(this)) {
                continue;
            }
            xNetForce += this.calcForceExertedByX(b[i]);
        }
        return xNetForce;
    }

    public double calcNetForceExertedByY(Planet[] b) {
        int num = b.length;
        double yNetForce = 0;
        for (int i = 0; i < num; i += 1){
            if (b[i].equals(this)) {
                continue;
            }
            yNetForce += this.calcForceExertedByY(b[i]);
        }
        return yNetForce;
    }
    /**calculate the accelerate caused by the force
     * and the new velocity and position in a small period of time dt
     */
    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }    

    /**draw Planet */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}