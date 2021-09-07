/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.busola.finalyearproject;

/**
 *
 * @author USER
 */
public class QuadraticInterpolation {
    
    public void run(Function f, double x1, double x3) {
        this.run(f, x1, x3, 1e-5);
    }
    
    public void run(Function f, double x1, double x3, double tol) {
        Stopwatch timer = new Stopwatch();
        double f1, f2, f3, x2, xbar, fbar, x0 = 1e99;
        x2 = 0.5*(x1 + x3);
        f1 = f.solve(x1);
        f2 = f.solve(x2);
        f3 = f.solve(x3);
        
//        xbar = ((x2*x2 - x3*x3)*f1 + (x3*x3 - x1*x1)*f2 + (x1*x1 - x2*x2)*f3)/(2*((x2 - x3)*f1 + (x3 - x1)*f2 + (x1 - x2)*f3));
//        fbar = f.solve(xbar);
        
        do {
            xbar = ((x2*x2 - x3*x3)*f1 + (x3*x3 - x1*x1)*f2 + (x1*x1 - x2*x2)*f3)/(2*((x2 - x3)*f1 + (x3 - x1)*f2 + (x1 - x2)*f3));
            fbar = f.solve(xbar);
            
            if (x1 < xbar && xbar < x2) {
                if (fbar <= f2) {
                    x3 = x2;
                    f3 = f2;
                    x2 = xbar;
                    f2 = fbar;
                } else {
                    x1 = xbar;
                    f1 = fbar;
                }
            }

            if (x2 < xbar && xbar < x3) {
                if (fbar <= f2) {
                    x1 = x2;
                    f1 = f2;
                    x2 = xbar;
                    f2 = fbar;
                } else {
                    x3 = xbar;
                    f3 = fbar;
                }
            }

            x0 = xbar;

        } while (Math.abs(xbar-x0) >= tol);
        
        System.out.printf("x∗ = %f and f(x∗) = %f", xbar, fbar);
        double time = timer.elapsedTime();
        System.out.printf(" (Finished in %.6f seconds)\n", time);

    }
    
    public void runsimplyfied(Function f, double x2, double t) {
        this.runsimplyfied(f, x2, t, 1e-5);
    }
    
    public void runsimplyfied(Function f, double x2, double t, double tol) {
        double f1, f2, f3, x3, x1, xbar, fbar, fmin, xmin;
        x1 = x2 - t;
        x3 = x2 + t;
        f1 = f.solve(x1);
        f2 = f.solve(x2);
        f3 = f.solve(x3);
        
        xbar = x2 + ((f1 - f3)*t)/(2*(f1 - (2*f2) + f3));
        fbar = f.solve(xbar);
        
        if (f1 <= f2 && f1 <= f3) {
            fmin = f1;
            xmin = x1;
        } else if (f2 <= f3 && f2 <= f1) {
            fmin = f2;
            xmin = x2;
        } else {
            fmin = f3;
            xmin = x3;
        }
        
        while (Math.abs(xbar-xmin) >= tol) {
            if (x1 < xbar && xbar < x2) {
                if (fbar <= f2) {
                    x3 = x2;
                    f3 = f2;
                    x2 = xbar;
                    f2 = fbar;
                } else {
                    x1 = xbar;
                    f1 = fbar;
                }
            }

            if (x2 < xbar && xbar < x3) {
                if (fbar <= f2) {
                    x1 = x2;
                    f1 = f2;
                    x2 = xbar;
                    f2 = fbar;
                } else {
                    x3 = xbar;
                    f3 = fbar;
                }
            }

            xmin = xbar;
            xbar = x2 + ((f1 - f3)*t)/(2*(f1 - (2*f2) + f3));
            fbar = f.solve(xbar);
        }
        
        System.out.printf("x∗ = %f and f(x∗) = %f", xbar, fbar);
    }
}
