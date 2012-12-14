package edu.unr.cse.paintmobile3d;

import java.util.concurrent.*;
import java.lang.Math;
import java.lang.Thread;

import android.os.SystemClock;

public class MockPoseEstimator extends PoseEstimator {
	protected volatile ConcurrentSkipListSet<Subscription> subscriptions;
	protected volatile EstimationRunnable estimationThread;
	
	public class Subscription implements IPoseSubscription {
		private volatile ConcurrentLinkedQueue<Vector3> positions;
		private volatile ConcurrentLinkedQueue<Vector3> orientations;
		
		public Vector3[][] update() {
			// Get the minimum sized queue to copy from
			int count = positions.size();
			int orientationsSize = orientations.size();
			if (orientationsSize < count)
				count = orientationsSize;
			
			// Pop from queues to results
			Vector3[][] result = new Vector3[count][2];
			for (int i = 0; i < count; i++) {
				result[i][0] = positions.poll();
				result[i][1] = orientations.poll();
			}
			
			return result;
		}
	}
	
	protected class EstimationRunnable extends Thread {
		public volatile boolean running;
		@Override
		public void run() {
			while (running) {
				// Calculate the current position
				Vector3 orientation = new Vector3(0,1,0);
				Vector3 position = new Vector3(
						Math.sin(7.0 * SystemClock.uptimeMillis()/1000),
						Math.sin(11.0 * SystemClock.uptimeMillis()/1000),
						Math.sin(13.0 * SystemClock.uptimeMillis()/1000));
				
				// Add the position to all subscribers
				for (Subscription subscription : subscriptions) {
					subscription.orientations.add(orientation);
					subscription.positions.add(position);
				}
				
				// Wait for a 60th of a second
				try {
					Thread.sleep(33);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public MockPoseEstimator() {
		subscriptions = new ConcurrentSkipListSet<Subscription>();
		estimationThread = new EstimationRunnable();
	}

	@Override
	public IPoseSubscription subscribe() {
		Subscription result = new Subscription();
		
		// Add to the subscription list
		subscriptions.add(result);
		
		return result;
	}

	@Override
	public synchronized void start() {
		// If the thread's not running
		if (estimationThread.running == false) {
			// Start the thread
			estimationThread.running = true;
			estimationThread.run();
		}
	}

	@Override
	public synchronized void stop(){
		// Stop the thread if it's running
		if (estimationThread.running == true) {
			estimationThread.running = false;
			// Wait for the thread to stop
			try {
				estimationThread.join(0);
			} catch (InterruptedException e) {
				
			} finally {
				// Remove any unused pose info
				for (Subscription subscription : subscriptions) {
					subscription.orientations.clear();
					subscription.positions.clear();
				}
			}
		}
	}

	/**
	 * This function does nothing for the mock object.
	 */
	@Override
	public void setPosition(Vector3 pos) {
		
	}

	/**
	 * This function does nothing for the mock object.
	 */
	@Override
	public void setOrientation(Vector3 orient) {

	}
}
