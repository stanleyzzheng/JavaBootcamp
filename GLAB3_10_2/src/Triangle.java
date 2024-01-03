public class
Triangle extends Shape {
    public Triangle(){

    }
    public Triangle(String color, double area, double base, double width, double height){
        super(color, area, base, width, height);
    }
    public Triangle(String color){
        super(color);
    }

    @Override
    public void setBase(double base) {
        super.setBase(base);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getArea() {
        return 0.5*base*height;
    }

    @Override
    public void displayshapeName() {
        System.out.println("I am a triAngle");
    }

    @Override
    public String toString() {
        return "Triangle[base=" + base + ",height=" + height + "," + super.toString() + "]";
    }
}
