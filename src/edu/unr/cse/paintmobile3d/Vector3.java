package edu.unr.cse.paintmobile3d;

import java.lang.Math;

public class Vector3 {
	public double x, y, z;
	
	/**
	 * Standard constructor
	 * @param _x x-coordinate
	 * @param _y y-coordinate
	 * @param _z z-coordinate
	 */
	public Vector3(double _x, double _y, double _z) {
		x = _x;
		y = _y;
		z = _z;
	}
	
	/**
	 * Return the dot product of this vector and another 
	 * @param rhs
	 * @return the dot product
	 */
	double dot(Vector3 rhs) {
		return x*rhs.x + y*rhs.y + z*rhs.z;
	}
	
	/**
	 * Return the cross product of this vector and another
	 * @param rhs
	 * @return the cross product
	 */
	Vector3 cross(Vector3 rhs) {
		return new Vector3(y*rhs.z - z*rhs.y,
				x*rhs.z - z*rhs.x,
				x*rhs.y - y*rhs.x);
	}
	
	/**
	 * calculates the length squared
	 * @return the length squared
	 */
	double lengthSquared() {
		return x*x + y*y + z*z;
	}
	
	/**
	 * returns the length of the vector
	 * @return the length
	 */
	double length() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	/**
	 * multiplies vectors with scalars
	 * @param s the scalar
	 * @return the multiplied vector
	 */
	Vector3 scalarMultiply(double s) {
		return new Vector3(x*s, y*s, z*s);
	}
	
	/**
	 * normalizes this vector
	 * @return the normalized vector
	 */
	Vector3 normalized() {
		return scalarMultiply(1/length());
	}
	
	/**
	 * adds vectors
	 * @param rhs
	 * @return the vector sum
	 */
	Vector3 add(Vector3 rhs) {
		return new Vector3(x + rhs.x, y + rhs.y, z + rhs.z);
	}
	
	/**
	 * subtracts vectors
	 * @param rhs
	 * @return The subtracted vector
	 */
	Vector3 sub(Vector3 rhs) {
		return new Vector3(x - rhs.x, y - rhs.y, z - rhs.z);
	}
}
