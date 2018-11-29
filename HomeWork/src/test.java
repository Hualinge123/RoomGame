
public class test {

	public static void main(String[] args) {
		
		You you= new You();
		you.setDaemon(true);
		you.start();

	}

}

class You extends Thread {
	
	public void run(){
		System.out.println("you");
	}
	
}

