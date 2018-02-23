package com.rijul;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String args[]) throws InterruptedException {

		Runner[] runners = new Runner[Constants.NUMBER_OF_PHILOSOPHER];
		Philosopher[] philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];
		Chopstick[] chopsticks = new Chopstick[Constants.NUMBER_OF_CHOPSTICK];

		for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICK; i++) {
			chopsticks[i] = new Chopstick(i);
		}

		for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER; i++) {
			philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICK]);
			runners[i] = new Runner(philosophers[i]);
		}

		ExecutorService executors = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);

		for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER; i++) {
			executors.submit(runners[i]);
		}

		Thread.sleep(Constants.TIME_OF_ITERATION);

		for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER; i++) {
			runners[i].setFinish(true);
		}

		executors.shutdown();

	}

}
