package com.kodilla.testing.shape;
import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("Starting tests for " + ShapeCollector.class);
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests finished "+ ShapeCollector.class);
    }

    @Before
    public void beforeEveryTest(){
//        testCounter++;
//        System.out.println("Test No: "+testCounter);
        //można skrócić
        System.out.println("Test No: "+ ++testCounter);
    }

    @Test
    public void testAddFigure(){

        //Given
        Square square = new Square(2.0);

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(square);

        //Then
        Assert.assertEquals(1,collector.getFiguresNumber());
    }

    @Test
    public void testAddNullFigure(){

        //Given

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(null);

        //Then
        Assert.assertEquals(0,collector.getFiguresNumber());

    }

    @Test
    public void testRemoveFigure(){

        //Given
        Square square = new Square(5.0);
        Triangle triangle = new Triangle(5.0,2.0);
        Circle circle = new Circle(2.0);

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(triangle);
        collector.addFigure(square);
        collector.addFigure(circle);
        Assert.assertEquals(3,collector.getFiguresNumber());
        boolean result = collector.removeFigure(circle);

        //Then
        Assert.assertTrue(result);
        //przydałoby sie sprawdzic jednak czy rzeczywiście usunieto, np
        Assert.assertEquals(2,collector.getFiguresNumber());


    }

    @Test
    public void testRemoveNotExistingFigure(){

        //Given
        Square square = new Square(5.0);
        Triangle triangle = new Triangle(5.0,2.0);
        Circle circle = new Circle(2.0);

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(triangle);
        collector.addFigure(square);
        boolean result = collector.removeFigure(circle);

        //Then
        Assert.assertFalse(result);

    }

    @Test
    public void testRemoveNullFigure(){

        //Given
        Square square = new Square(5.0);
        Triangle triangle = new Triangle(5.0,2.0);

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(triangle);
        collector.addFigure(square);
        boolean result = collector.removeFigure(null);

        //Then
        Assert.assertFalse(result);

    }

    @Test
    public void testGetFigure(){

        //Given
        Square square = new Square(5.0);
        Triangle triangle = new Triangle(5.0,2.0);

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(triangle);
        collector.addFigure(square);
        Shape shape = collector.getFigure(1);

        //Then

        //tutaj można by było jeszcze sprawdzić operatorem instanceof czy jest dobrego typu,
        Assert.assertTrue(shape instanceof Square);
        //dla lepszej czytelności
        Assert.assertEquals(square,shape);

    }

    @Test
    public void testGetFigureOutOfRange(){

        //Given

        //When
        ShapeCollector collector = new ShapeCollector();
        Shape shape = collector.getFigure(5);

        //Then
        Assert.assertEquals(null,shape);
    }

    @Test
    public void testShowFigures(){

        //Given
        Triangle triangle = new Triangle(5.0,2.0);
        Square square = new Square(2.0);
        Circle circle = new Circle(5.0);
        String expected = "Triangle, Square, Circle";

        //When
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(triangle);
        collector.addFigure(square);
        collector.addFigure(circle);
        String result = collector.showFigures();

        //Then
        Assert.assertEquals(expected,result);
    }

}
