package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
	
		if (n == 0) 
			return 0;
		else if (n == 1) 
			return 1.0/2;
		else 
			return geometricSum(n-1) + 1.0 / Math.pow(2,n);

		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
		if (p % q == 0)
			{
			return q;
			}
		else
			{
			gcd(q, p % q);
			return gcd(q, p % q);
			}
			
		
	}

	
	public static int[] reverse(int[] array, int[]reverseArray, int index) {
		if ((array.length + 1) / 2 == index )
		{
			return reverseArray;
		}
		else
		{
			reverseArray [array.length - 1 - index] = array[index];
			reverseArray [index] = array[array.length - 1 - index]; 
			return reverse(array, reverseArray, index + 1);
		}
		
		
		
	}
	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {

			int reverseArray[] = new int[array.length];
			return reverse(array, reverseArray, 0);
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
		double bound = 5.0;
		StdDraw.setXscale(-bound, bound);
		StdDraw.setYscale(-bound, bound);
		
		if (radius < radiusMinimumDrawingThreshold)
			{
			StdDraw.circle(xCenter, yCenter, radius);
			}
		else
			{
			StdDraw.circle(xCenter, yCenter, radius);
			circlesUponCircles(xCenter - radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter + radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius, radius/3.0, radiusMinimumDrawingThreshold);
			}
		// this is acting a little funky
	}

}
