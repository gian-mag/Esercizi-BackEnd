package Es_3;

public class Main1 {

	public static void main(String[] args) {

		Thread1 test1 = new Thread1("*");
		Thread2 test2 = new Thread2("#");
		test1.start();
		test2.start();
	}
}

class Thread1 extends Thread {

	Thread1(String name) {
		this.setName(name);
	}

	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				System.out.println(getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class Thread2 extends Thread {

	Thread2(String name) {
		this.setName(name);
	}

	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				System.out.println(getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
