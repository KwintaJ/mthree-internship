public class Question4
{
    public static void main(String[] args)
    {
        Shape[] arrrayOfShapes = new Shape[3];

        arrrayOfShapes[0] = new Triangle();
        arrrayOfShapes[1] = new Polygon();
        arrrayOfShapes[2] = new Circle();

        for(Shape sh : arrrayOfShapes)
        {
            sh.draw();
        }
    }
}

abstract class Shape
{
    abstract public void draw();
}

class Triangle extends Shape
{
    @Override
    public void draw()
    {
        System.out.println("drawing a triangle");
    }
}

class Polygon extends Shape
{
    @Override
    public void draw()
    {
        System.out.println("drawing a polygon");
    }
}

class Circle extends Shape
{
    @Override
    public void draw()
    {
        System.out.println("drawing a circle");
    }
}