public class myRunner {
    public static void main(String[] args){
        Circle c = new Circle(100);
        System.out.println("Area of Circle " + c.getArea());

        Shape sObj = new Shape();
        sObj.displayshapeName();
        System.out.println(sObj instanceof Shape);

        System.out.println("++++++++++++++++++");

        Shape shapeCircleObj = new Circle(100); // upCasting
        shapeCircleObj.displayshapeName();
        System.out.println("Area of Circle " + shapeCircleObj.getArea());
        System.out.println(shapeCircleObj); // Run circle's toString()
        // Use instanceof operator for validation
        System.out.println(shapeCircleObj instanceof Circle); //true
        System.out.println("----------------");
        Shape shapeRectangleObj = new Rectangle("Red");
        shapeRectangleObj.displayshapeName();
        shapeRectangleObj.setHeight(2);
        shapeRectangleObj.setWidth(2);
        System.out.println("Area of Rectangle is " + shapeRectangleObj.getArea());
        System.out.println(shapeRectangleObj); // Run Rectangle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeRectangleObj instanceof Rectangle);
        System.out.println(sObj instanceof Rectangle);

        System.out.println("___________________");
        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
        shapeTriangleObj.displayshapeName();
        shapeTriangleObj.setHeight(2);
        shapeTriangleObj.setBase(3);
        System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
        System.out.println(shapeTriangleObj);

        System.out.println(shapeTriangleObj instanceof Triangle);
        System.out.println(sObj instanceof Triangle);

        System.out.println("---------------");

        Cylinder cylinderShape = new Cylinder(3); //upcasting
        cylinderShape.displayshapeName();
        cylinderShape.setHeight(3);
        System.out.println("Area of cylinder is " + cylinderShape.getVolume());
        System.out.println(cylinderShape);
    }
}
