package migu.jdp.createpattern;
import java.util.LinkedList;


//Builders common interface
interface IBuilder
{
     void BuildBody();
     void InsertWheels();
     void AddHeadlights();
     Product GetVehicle();

}

//Car is ConcreteBuilder
class Car implements IBuilder
{
     private Product product = new Product();

     @Override
     public void BuildBody()
     {
             product.Add("This is a body of a Car");
     }
     @Override
     public void InsertWheels()
     {
             product.Add("4 wheels are added");
     }
     @Override
     public void AddHeadlights()
     {
             product.Add("2 Headlights are added");
     }
     @Override
     public  Product GetVehicle()
     {
             return product;
     }

}

//Motorcycle is a ConcreteBuilder
class MotorCycle implements IBuilder
{
     private Product product = new Product();

     @Override
     public  void BuildBody()
     {
             product.Add("This is a body of a Motorcycle");
     }
     @Override
     public void InsertWheels()
     {
             product.Add("2 wheels are added");
     }
     @Override
     public void AddHeadlights()
     {
             product.Add("1 Headlights are added");
     }
     @Override
     public  Product GetVehicle()
     {
             return product;
     }
}

//"Product"
class Product
{
     // We can use any data structure that you prefer. We have used LinkedList here.
     private LinkedList<String> parts;
     public Product()
     {
             parts = new LinkedList<String>();
     }

     public void Add(String part)
     {
             //Adding parts
             parts.addLast(part);
     }

     public void Show()
     {
             System.out.println("\n Product completed as below :");
             for(int i=0;i<parts.size();i++)
             {
                     System.out.println(parts.get(i));
             }
     }
}
//"Director"
class Director
{
     IBuilder myBuilder;

     // A series of steps—for the production
     public void Construct(IBuilder builder)
     {
             myBuilder=builder;
             myBuilder.BuildBody();
             myBuilder.InsertWheels();
             myBuilder.AddHeadlights();
     }
}

/**
 * Separate the construction of a complex object from its representation 
 * so that the same construction processes can create different representations.
 * 
 * Car and MotorCycle are the concrete implementations. They have implemented IBuilder interface. 
 * That’s why they needed to BuildBody(), InsertWheels(), AddHeadlights(), and finally GetVehicle(). 
 * We use the first three methods to build the body of the vehicle, insert the number of wheels into it, and add headlights to the vehicle. 
 * GetVehicle() will return the ultimate product. 
 * 
 * Finally, Director will be responsible for constructing the ultimate vehicle. Director will build the product with IBuilder interface. He is calling the same Construct() method to create different types of vehicles.
 * The builder pattern is an object creation software design pattern. 
 * 
 * Unlike the abstract factory pattern and the factory method pattern whose intention is to 
 * enable polymorphism, the intention of the builder pattern is to find a solution to the 
 * telescoping constructor anti-pattern[citation needed]. The telescoping constructor 
 * anti-pattern occurs when the increase of object constructor parameter combination 
 * leads to an exponential list of constructors. Instead of using numerous constructors, 
 * the builder pattern uses another object, a builder, that receives each initialization parameter 
 * step by step and then returns the resulting constructed object at once.
 * 
 * Builder often builds a Composite. Often, designs start out using Factory Method (less complicated, more customizable, subclasses proliferate) and 
 * evolve toward Abstract Factory, Prototype, or Builder (more flexible, more complex) as 
 * the designer discovers where more flexibility is needed. Sometimes creational patterns are 
 * complementary: Builder can use one of the other patterns to implement which components are built.
 * @author migu
 *
 */
public class Builder {

	public static void main(String[] args) {
		System.out.println("***Builder Pattern Demo***\n");

        Director director = new Director();

        IBuilder carBuilder = new Car();
        IBuilder motorBuilder = new MotorCycle();

        // Making Car
        director.Construct(carBuilder);
        Product p1 = carBuilder.GetVehicle();
        p1.Show();

        //Making MotorCycle
        director.Construct(motorBuilder);
        Product p2 = motorBuilder.GetVehicle();
        p2.Show();
	}

}
