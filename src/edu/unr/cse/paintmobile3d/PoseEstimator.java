package edu.unr.cse.paintmobile3d;

public abstract class PoseEstimator {
	/**
	 * This class represents a subscription to the points that this estimator
	 * tracks.
	 * @author tommy
	 *
	 */
	abstract public class Subscription implements IPoseSubscription {
		/**
		 * gets the points since the last time asked
		 * 
		 * @return an array where each row is a time step, the first column
		 * is position and the second is orientation 
		 */
		abstract public Vector3[][] update();
	}
	abstract public IPoseSubscription subscribe();
	
	/**
	 * Starts the pose estimator
	 */
	abstract public void start();
	/**
	 * Stops the pose estimator
	 */
	abstract public void stop();
	/**
	 * Sets the position
	 * @param pos
	 */
	abstract public void setPosition(Vector3 pos);
	/**
	 * Sets the orientation
	 * @param orient
	 */
	abstract public void setOrientation(Vector3 orient);
}
