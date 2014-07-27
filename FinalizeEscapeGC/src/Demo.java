
public class Demo {

	public static Demo demo = null;
	
	public void isAlive(){
		
		System.out.println("I am alive...........");
	}

	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
		System.out.println("finalize()");
		Demo.demo = this;
	}
	public static void main(String [] args) throws InterruptedException{
		demo = new Demo();
		
		demo = null;
		System.gc();
		Thread.sleep(1000);
		if(demo != null){
			demo.isAlive();
		}
		else{
			System.out.println("I am died");
		}
		
		demo = null;
		System.gc();
		Thread.sleep(1000);
		if(demo != null){
			demo.isAlive();
		}
		else{
			System.out.println("I am died..........");
		}
		
		
	}
	
}
