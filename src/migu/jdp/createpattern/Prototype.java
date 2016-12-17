package migu.jdp.createpattern;

import java.util.Random;
/**
 * The prototype pattern provides an alternative method for instantiating new objects by copying or 
 * cloning an instance of an existing one. Creating a new instance, in a real-world scenario, 
 * is normally treated as an expensive operation. 
 * 
 * This pattern helps us to deal with this issue. Our focus here is to reduce the expense of this 
 * creational process of a new instance.
 * 
 * https://en.wikipedia.org/wiki/Prototype_pattern
 * @author migu
 *
 */
abstract class BasicCar implements Cloneable
{
    public String modelname;
    public int price;

    public String getModelname()
    {
        return modelname;
    }
    public void setModelname(String modelname)
    {
        this.modelname = modelname;
    }

    public static int setPrice()
    {
        int price = 0;
        Random r = new Random();
        int p = r.nextInt(100000);
        price = p;
       return price;
    }
   public BasicCar clone() throws CloneNotSupportedException
   {
                return  (BasicCar)super.clone();
   }

}
//Ford.java
class Ford extends BasicCar
{
    public Ford(String m)
    {
        modelname = m;
    }

        @Override
        public BasicCar clone() throws CloneNotSupportedException
        {
                 return (Ford)super.clone();
        }
}
//Nano.java
class Nano extends BasicCar
{
    public Nano(String m)
    {
        modelname = m;
    }
        @Override
        public BasicCar clone() throws CloneNotSupportedException
        {
                 return (Nano)super.clone();

        }
}

public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		   System.out.println("***Prototype Pattern Demo***\n");
	       BasicCar nano_base = new Nano("Green Nano");
	       nano_base.price=100000;

	       BasicCar ford_basic = new Ford("Ford Yellow");
	       ford_basic.price=500000;

	       BasicCar bc1;
	        //Clone Nano Object
	       bc1 =nano_base.clone();
	       //Price will be more than 100000 for sure
	       bc1.price = nano_base.price+BasicCar.setPrice();
	       System.out.println("Car is: "+ bc1.modelname+" and it’s price is Rs."+bc1.price);

	       //Clone Ford Object
	       bc1 =ford_basic.clone();
	       //Price will be more than 500000 for sure
	       bc1.price = ford_basic.price+BasicCar.setPrice();
	       System.out.println("Car is: "+ bc1.modelname+" and it’s price is Rs."+bc1.price);
	}
}
