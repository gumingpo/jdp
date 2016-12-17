package migu.jdp.structualpattern;

abstract class Subject {
	public abstract void perform();
}

class RealSubject extends Subject {

	@Override
	public void perform() {
		System.out.println("ConcreteSubject.perform()");
	}
}

/**
 * A proxy, in its most general form, is a class functioning as an interface to something else.
 * In short, a proxy is a wrapper or agent object that is being called by the client to access the real serving object behind the scenes.
 * Use of the proxy can simply be forwarding to the real object, or can provide additional logic.
 * In the proxy extra functionality can be provided, for example caching when operations on the real object are resource intensive, or 
 * checking preconditions before operations on the real object are invoked.
 * 
 * For the client, usage of a proxy object is similar to using the real object, because both implement the same interface.
 * 
 * Proxy types:
 * Remote proxies: They will hide that actual object which is in a different address space.
 * Virtual proxies: In place of a complex or heavy object, a skeleton representation may be advantageous in some cases. When an underlying image is huge in size, it may be represented using a virtual proxy object, loading the real object on demand.
 * Protection proxies: A protection proxy might be used to control access to a resource based on access rights.
 * Smart reference: It can also perform some additional housekeeping work when an object is accessed. 
 *                  A typical operation is counting the number of references to the actual object.
 * @author migu
 */
public class Proxy extends Subject{
	RealSubject cs;
	
	public Proxy(RealSubject cs) {
		this.cs = cs;
	}
	
	public Proxy() {
	}
	@Override
	public void perform() {
		System.out.println("Proxy.perform()");
		
		//Lazy initialization
		// We must remember that in the real programming world, the creation of multiple instances of 
		// a complex object (heavy object) is very costly. In such situations, 
		// we can create multiple proxy objects (which must point to an original object) and the 
		// total creation of actual objects can be carried out on a demand basis.
		// Thus we can save both the memory and creational time.
		if(cs == null) cs = new RealSubject();
		cs.perform();
	}
	
	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		proxy.perform();
	}
}
