package migu.jdp.structualpattern;

interface Image {
	public void displayImage();
}

class RealImage implements Image {
    private String fileName = null;
    
    public RealImage(final String fileName) {
    	this.fileName = fileName;
    	loadImageFromDisk();
    }
    
    private void loadImageFromDisk() {
    	System.out.println("Loading " + fileName);
    }
    
	@Override
	public void displayImage() {
		System.out.println("Displaying " + fileName);
	}
}

/**
 * In place of a complex or heavy object, a skeleton representation may be advantageous in some cases. 
 * When an underlying image is huge in size, it may be represented using a virtual proxy object, 
 * loading the real object on demand.
 * @author migu
 *
 */
class ImageProxy implements Image {
    private RealImage image = null;
    private String fileName = null;
    
    public ImageProxy(final String fileName) {
    	this.fileName = fileName;
    }
    
	@Override
	public void displayImage() {
		// TODO Auto-generated method stub
		if(image == null) {
			image = new RealImage(fileName);
		}
		
		image.displayImage();
	}
	
}

public class VirtualProxy {
	public static void main(String[] args) {
		Image imageProxy1 = new ImageProxy("photo1");
		Image imageProxy2 = new ImageProxy("photo2");
		imageProxy1.displayImage();
		imageProxy1.displayImage();
		imageProxy2.displayImage();
		imageProxy2.displayImage();
	}
}
