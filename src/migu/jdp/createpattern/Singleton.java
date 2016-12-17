package migu.jdp.createpattern;

/**
 * Ensure a class only has one instance, and provide a global point of access to it.
 */
public class Singleton {
	/**
	 * For test purpose
	 */
	public static long instanceCount = 0;
	
	private static Singleton _instance;
	
	private Singleton() {instanceCount++;}
	
	/**
	 * synchronized is to assure thread-safe
	 * @return
	 */
	public synchronized static Singleton getInstance() {
		if(_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}
	
	public static void main(String[] args) {
		for(int i=0; i< 10000; i++) {
			new Thread() {
				public void run() {
					Singleton.getInstance();
				}
			}.start();
		}
		
		if(Singleton.instanceCount > 1) {
            System.out.println("not Thread-safe");
		} else {
			System.out.println("Thread-safe");
		}
	}
}
