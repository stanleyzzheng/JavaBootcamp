public class Triangle extends Shape{
    public Triangle(){}
    public Triangle(String color){
        super.color =color;
    }
    public void setBase(int base){
        this.base=base;
    }
    @Override
    public double getArea(){
        return .5*super.base *super.height;
    }
    @Override
    public void displayShapeName(){
        System.out.println("I am a triangle");
    }

    @Override
    public String toString() {
        return "Triangle[base="+super.base+",height="+super.height +"," +super.toString() + "]";
    }
}
