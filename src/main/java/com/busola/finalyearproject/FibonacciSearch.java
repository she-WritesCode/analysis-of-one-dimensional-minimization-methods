/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.busola.finalyearproject;

/**
 * 
 * @author Busola Okeowo
 */
public class FibonacciSearch {
    
    /**
     * Fibonacci Search Method
     * @param f - function to be evaluated
     * @param n - no of iterations
     * @param a - left side of interval
     * @param b - right side of interval
     * 
     * // @return midpoint of shrunken [a,b]
     */
    public void run(Function f, int n, double a, double b) {
        Stopwatch timer = new Stopwatch();
        
        int i, j;
        int[] fib = new int[n+1]; // fibonacci numbers
        double h, fa, fb, c, d;
        fib[0] = 1;
	fib[1] = 1;
        
        for(i = 2; i<=n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            //System.out.println(fib[i]);
        }
        
        h = b - a;
        
        h = ((double) fib[n-2]/ (double) fib[n]) * h;
        c = b - h;
        d = a + h;
        fa = f.solve(c);
        fb = f.solve(d);
        
        System.out.println("a \t\t xa \t\t b \t\t xb \t\t fa \t\t fb \t\t Lj+1 \t\t Fn-2 \t Fn \t L*j+2");
        j = 2;
        while ((c < d || j != n-2)) {
            h = ((double) fib[n-j-1]/ (double)fib[n-j])*h;
            
            System.out.printf("%f \t %f \t %f \t %f \t %f \t %f \t %f \t %d, \t %d%n", a, c, b, d, fa, fb, h, fib[n-j-1], fib[n-j]);
            
            if (fa >= fb) {
               a = c; 
               // b = b;
               c = d;
               d = a + h;
               fa = fb;
               fb = f.solve(d);
               
            } else {
               // a = a;
               b = d;
               d = c;
               c = b - h;
               fb = fa;
               fa = f.solve(c);

            } 
            j++;
//            if ( c > d || j == n-2 ) {
//                break;
//            }
        }
        System.out.printf("a = %f, b = %f, x∗ = %f, f(x∗) = %f, and  Ln = %f%n", c, d, (d+c)/2, f.solve((d+c)/2), Math.abs(d-c));
        
        double time = timer.elapsedTime();
        System.out.printf(" (Finished in %.6f seconds)\n", time);
        
    }
}
