package migu.jdp.createpattern;

interface IAnimal
{
        void speak();
}
class Duck implements IAnimal
{
        @Override
        public void speak()
        {
                System.out.println("Duck says Pack-pack");
        }
}
class Tiger implements IAnimal
{
        @Override
        public void speak()
        {
                System.out.println("Tiger says: Halum..Halum");

        }
}
abstract class IAnimalFactory
{
        public abstract IAnimal GetAnimalType(String type) throws Exception;
}
class ConcreteFactory extends IAnimalFactory
{
        @Override
        public  IAnimal GetAnimalType(String type) throws Exception
        {
                switch (type)
                {
                case "Duck":
                    return new Duck();
                case "Tiger":
                    return new Tiger();
                default:
                        throw new Exception( "Animal type : "+type+" cannot be instantiated");
                }
        }
}

/**
 * method-param decides which kind of object to create.
 * Factory-method is just one method.
 * Define an interface for creating an object, but let subclasses decide which class to instantiate. 
 * The Factory method lets a class defer instantiation it uses to subclasses
 * @author migu
 *
 */
public class FactoryMethod {

	public static void main(String[] args) throws Exception {
		System.out.println("***Factory Method Pattern Demo***\n");
        IAnimalFactory animalFactory = new ConcreteFactory();
        IAnimal DuckType=animalFactory.GetAnimalType("Duck");
        DuckType.speak();

        IAnimal TigerType = animalFactory.GetAnimalType("Tiger");
        TigerType.speak();
        //There is no Lion type. So, an exception will be thrown
        IAnimal LionType = animalFactory.GetAnimalType("Lion");
        LionType.speak();
	}

}
