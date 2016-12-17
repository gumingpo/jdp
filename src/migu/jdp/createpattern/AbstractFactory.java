package migu.jdp.createpattern;
interface ITollywoodMovie {
	String movieName();
}

interface IBollywoodMovie {
	String movieName();
}

/**
 * An interface is used to create related objects. Here we do not call their implementer or concrete classes directly. 
 * We sometimes refer to this pattern as a factory of factories or a Super factory.
 */
interface IMovieFactory {
	ITollywoodMovie getTollywoodMovie();
	IBollywoodMovie getBollywoodMovie();
}

class TollywoodActionMovie implements ITollywoodMovie {

	@Override
	public String movieName() {
		return "Kranti is a Tollywood Action Movie";
	}
}

class TollywoodComedyMovie implements ITollywoodMovie
{
    @Override
    public String movieName()
    {
        return "BasantaBilap is a Tollywood Comedy Movie";
    }
}

//Bollywood Movie collections
class BollywoodActionMovie implements IBollywoodMovie
 {
        @Override
        public String movieName()
     {
         return "Bang Bang is a Bollywood Action Movie";
     }
 }

class BollywoodComedyMovie implements IBollywoodMovie
 {
        @Override
        public String movieName()
     {
         return "Munna Bhai MBBS is a Bollywood Comedy Movie";
     }
 }

//Action Movie Factory
class ActionMovieFactory implements IMovieFactory
{
    public ITollywoodMovie getTollywoodMovie()
    {
        return new TollywoodActionMovie();
    }

    public IBollywoodMovie getBollywoodMovie()
    {
        return new BollywoodActionMovie();
    }
}
//Comedy Movie Factory
class ComedyMovieFactory implements IMovieFactory
{
    public ITollywoodMovie getTollywoodMovie()
    {
        return new TollywoodComedyMovie();
    }

    public IBollywoodMovie getBollywoodMovie()
    {
        return new BollywoodComedyMovie();
    }
}

/**
 * concret factory decides which kind of object to create.
 * Provides an interface for creating families of related or 
 * dependent objects without specifying their concrete classes.
 * In this example, our client is looking for movies and he/she needs to access 
 * an Abstract Factory, IMovieFactory, and Abstract Products, ITollywoodMovie and IBollywoodMovie. 
 * The client does not care which of these factories is giving the concrete object for him/her. 
 * He/she uses only the generic interfaces of their products.
 * 
 * 
 * Abstract factory creates a base class with abstract methods defining methods for the objects that should be created. 
 * Each factory class which derives the base class can create their own implementaton of each object type.
 * http://stackoverflow.com/questions/5739611/differences-between-abstract-factory-pattern-and-factory-method
 * 
 * @author migu
 */
public class AbstractFactory {
	public static void main(String[] args)
    {
        System.out.println("***Abstract Factory Pattern Demo***");
        IMovieFactory actionMovies = new ActionMovieFactory();
        ITollywoodMovie tAction = actionMovies.getTollywoodMovie();
        IBollywoodMovie bAction = actionMovies.getBollywoodMovie();
        System.out.println("\nAction movies  are:");
        System.out.println(tAction.movieName());
        System.out.println(bAction.movieName());

        IMovieFactory comedyMovies = new ComedyMovieFactory();
        ITollywoodMovie tComedy = comedyMovies.getTollywoodMovie();
        IBollywoodMovie bComedy = comedyMovies.getBollywoodMovie();

        System.out.println("\nComedy movies  are:");
        System.out.println(tComedy.movieName());
        System.out.println(bComedy.movieName());
    }
}
