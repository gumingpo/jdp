package migu.jdp.structualpattern;
/** "Composite" */
import java.util.List;
import java.util.ArrayList;

/** 
 * In software engineering, the composite pattern is a partitioning design pattern. 
 * The composite pattern describes that a group of objects is to be treated in the same way 
 * as a single instance of an object. 
 * 
 * The intent of a composite is to "compose" objects into tree structures to represent part-whole 
 * hierarchies. Implementing the composite pattern lets clients treat individual objects and 
 * compositions uniformly
 */

/**
 * Component
 * @author migu
 *
 */
interface Graphic {
    //Prints the graphic.
    public void print();
}

class CompositeGraphic implements Graphic {

    //Collection of child graphics.
    private List<Graphic> childGraphics = new ArrayList<Graphic>();

    //Prints the graphic.
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }
}

/** "Leaf" */
class Ellipse implements Graphic {
   private String name;
	public Ellipse(final String name) {
		this.name = name;
	}
    //Prints the graphic.
    public void print() {
        System.out.println("" + name);
    }
}

public class Composite {

	public static void main(String[] args) {
		//Initialize four ellipses
        Ellipse ellipse1 = new Ellipse("ellipse1");
        Ellipse ellipse2 = new Ellipse("ellipse2");
        Ellipse ellipse3 = new Ellipse("ellipse3");
        Ellipse ellipse4 = new Ellipse("ellipse4");

        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();

        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);

        graphic2.add(ellipse4);

        graphic.add(graphic1);
        graphic.add(graphic2);

        //Prints the complete graphic (four times the string "Ellipse").
        graphic.print();
	}
}
