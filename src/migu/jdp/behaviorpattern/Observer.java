package migu.jdp.behaviorpattern;
/**
 * Define a one-to-many dependency between objects so that when one object changes state, 
 * all its dependents are notified and updated automatically.
 * 
 * In this pattern, there are many observers (objects) which are observing a particular subject (object). 
 * Observers are basically interested and want to be notified when there is a change made inside that subject.
 * 
 * Sometimes this model is also referred to as the Publisher-Subscriber model.
 */
import java.util.ArrayList;
import java.util.List;

interface ISubject {
	void register(IObserver o);
	void unregister(IObserver o);
	void notifyObservers(int i);
}

class Subject implements ISubject {
	private static long instanceCount = 0;
	private String subjectName = "Subject";
	public Subject() {
		instanceCount++;
		subjectName = "Subject" + instanceCount;
	}
	private int value;
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		notifyObservers(value);
	}

	private List<IObserver> observerList = new ArrayList<IObserver>();
	
	@Override
	public void register(IObserver o) {
		observerList.add(o);
	}

	@Override
	public void unregister(IObserver o) {
		observerList.remove(o);
	}

	@Override
	public void notifyObservers(int value) {
		for(int i=0; i < observerList.size(); i++) {
			observerList.get(i).update(subjectName,value);
		}
	}
}

interface IObserver {
	void update(String subject, int i);
}

public class Observer implements IObserver{
	private static long instanceCount = 0;
	private String observerName;
	public Observer() {
		instanceCount++;
		observerName = "Observer" + instanceCount;
	}
	
	@Override
	public void update(String subject, int value) {
		System.out.println("" + subject + " -> " + observerName + ": " + value);
		
	}
	
	public static void main(String[] args) {
        Subject sub1 = new Subject();
        IObserver obs1 = new Observer();
        IObserver obs2 = new Observer();
        
        sub1.register(obs1);
        sub1.register(obs2);
        
        sub1.setValue(1);
        sub1.setValue(2);
        
        sub1.unregister(obs1);
        
        sub1.setValue(3);
        
        IObserver obs3 = new Observer();
        Subject sub2 = new Subject();
        sub2.register(obs2);
        sub2.register(obs3);
        sub2.setValue(10);
        sub2.setValue(20);
        sub2.unregister(obs3);
        sub2.setValue(30);
	}
}
