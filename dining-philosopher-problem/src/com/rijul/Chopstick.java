package com.rijul;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

	private int id;
	private Lock lock;

	public Chopstick(int id) {
		this.id = id;
		this.lock = new ReentrantLock(true);
	}

	public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {

		if (lock.tryLock(1, TimeUnit.SECONDS)) {
			System.out.println(philosopher + " Picked up " + state + " " + this);
			return true;
		} else {
			System.out.println(philosopher + " failed to pick up " + state + " " + this);
			return false;
		}
	}
	
	public boolean putDown(Philosopher philosopher, State state) {
		
		lock.unlock();
		
		System.out.println(philosopher + " put down " + state + " " + this);
		
		return true;
	}

	@Override
	public String toString() {
		return "Chopstick [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lock == null) ? 0 : lock.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chopstick other = (Chopstick) obj;
		if (id != other.id)
			return false;
		if (lock == null) {
			if (other.lock != null)
				return false;
		} else if (!lock.equals(other.lock))
			return false;
		return true;
	}

}
