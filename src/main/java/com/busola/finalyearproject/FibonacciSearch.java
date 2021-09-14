/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.busola.finalyearproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Busola Okeowo
 */
public class FibonacciSearch {
    private static final int max = 75;
    
    public void run(Function f, double a, double b) {
        this.run(f, a, b, 1e-6);
    }
    
    public void run(Function f, double a, double b, double eps) {
        System.out.println("\nFibonacci Search >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Stopwatch timer = new Stopwatch();
        
        int itr, n;
        List<Integer> fib = new ArrayList(); // fibonacci numbers
        double c,d,fc,fd;
        
        fib.add(1);
        fib.add(1);
        
        for(n = 2; n <= max; n++) {
            fib.add(n, fib.get(n-1) + fib.get(n-2));
            if (fib.get(n) >((b-a)/eps)) break;
        }
        
//        System.out.printf("n = %d fibn= %d%n", n, fib.get(n));
        
        c = a + (double)fib.get(n-2)/(double)fib.get(n)*(b-a);
        d = a + (double)fib.get(n-1)/(double)fib.get(n)*(b-a);    
        fc = f.solve(c);
        fd = f.solve(d);    
//        System.out.println("n,a,c,d,b");
        
        itr = 0;
//        System.out.printf("%d, %f, %f, x* = %f, f(x*) = %f\n", itr, c,d, (c+d)/2, f.solve((c+d)/2));
        
        for (n = n-1; n > 2; n--) {
        
            if(fc < fd) {
                b = d;
                d = c;
                fd = fc;
                c = a + ((double)fib.get(n-2)/(double)fib.get(n))*(b-a);
                fc = f.solve(c);
            } else {
                a = c;
                c = d;
                fc = fd;
                d = a + ((double)fib.get(n-1)/(double)fib.get(n))*(b-a);
                fd = f.solve(d);
            }
            
            itr++;
            System.out.printf("%d, [%f, %f], f(x*) = %f\n", itr,c,d, Math.min(f.solve(c), f.solve(d)));
        }
        System.out.printf("iterations %d, x* = %f, f(x*) = %f", itr,(c+d)/2, f.solve((c+d)/2));

        
        double time = timer.elapsedTime();
        System.out.printf(" (Finished in %.6f seconds)\n", time);
        
    }
    
    public void run7(Function f, int n, double a, double b) {
        Stopwatch timer = new Stopwatch();
        
        int i, j = 2;
        int[] fib = new int[n+1]; // fibonacci numbers
        double x1, x2, fx1, fx2, L2, L1, L0;
        
        L0 = b-a;
        
        fib[0] = 1;
        fib[1] = 1;
        for(i = 2; i<=n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println(Arrays.toString(fib));
        L2 = ( (double)fib[n-2]/(double)fib[n])*L0;
        
        while (j != n-1) {
            L1 = b-a;

            if(L2 > L1/2) {
                x1 = b-L2;
                x2 = a+L2;
            } else {
                x1 = a+L2;
                x2 = b-L2;
            }
            fx1 = f.solve(x1);
            fx2 = f.solve(x2);

            if (fx1> fx2) {
                a = x1;
                L2 = (double)fib[n-j]*L1/(double)fib[n-j-2];
            } else if (fx2> fx1) {
                b = x2;
                L2 = (double)fib[n-j]*L1/(double)fib[n-j-2];
            } else {
                a = x1;
                b = x2;
                L2 = (double)fib[n-j]*(b-a)/(double)fib[n-j-2];
            }
        
            if (a > b) break;

            j++;
        }
        
        System.out.printf("a = %f, b = %f,  Ln = %f, x∗ = %f, and f(x∗) = %f%n", b, a, Math.abs(b-a), (b+a)/2, f.solve((b+a)/2) );
        
        double time = timer.elapsedTime();
        System.out.printf(" (Finished in %.6f seconds)\n", time);
        
    }
    
    /**
     * Fibonacci Search Method
     * @param f - function to be evaluated
     * @param n - no of iterations
     * @param a - left side of interval
     * @param b - right side of interval
     * 
     * // @return midpoint of shrunken [a,b]
     */
    public void old(Function f, int n, double a, double b) {
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
