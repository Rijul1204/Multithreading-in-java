package com.rijul;

import java.util.Random;

public class Philosopher {

	private int id;
	private Chopstick leftChopStick;
	private Chopstick rightChopStick;
	private Random random;

	public Philosopher(int id, Chopstick leftChopStick, Chopstick rightChopStick) {
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
		this.random = new Random();
	}

	public void think() throws InterruptedException {
		System.out.println(this + " is thinking ");
		Thread.sleep(random.nextInt(10000));
	}

	public void eat() throws InterruptedException {

		if (this.leftChopStick.pickUp(this, State.LEFT)) {
			if (this.rightChopStick.pickUp(this, State.RIGHT)) {
				System.out.println(this + " Started eating ");
				Thread.sleep(random.nextInt(10000));

				this.leftChopStick.putDown(this, State.LEFT);
				this.rightChopStick.putDown(this, State.RIGHT);

			} else {
				this.leftChopStick.putDown(this, State.LEFT);
			}
		} else {
			System.out.println(this + " couldn't eat");
		}
	}

	@Override
	public String toString() {
		return "Philosopher [id=" + id + "]";
	}

}
