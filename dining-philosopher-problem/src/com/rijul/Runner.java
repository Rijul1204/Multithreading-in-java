package com.rijul;

public class Runner implements Runnable {

	Philosopher philosopher;
	private volatile boolean isFinish = false;

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public Runner(Philosopher philosopher) {
		this.philosopher = philosopher;
	}

	@Override
	public void run() {

		while (!isFinish) {

			try {
				this.philosopher.think();
				this.philosopher.eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
