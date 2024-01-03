public class Circle extends Shape{
    protected double radius;
    private final double PI = Math.PI;

    public Circle(double radius){
        this.radius=radius;
    }

    public Circle(double radius, double height){
        this.radius=radius;
        super.height = height;
    }

//    @Override
    public double getArea() {
        super.area = PI*Math.pow(this.radius, 2);
        return super.area;
    }

    @Override
    public void displayshapeName(){
        System.out.println("Drawing a Circle of radius " + this.radius);
    }

    @Override
    public String toString(){
        return "Circle[ radius = " + radius + super.toString() + "]";
    }
}
