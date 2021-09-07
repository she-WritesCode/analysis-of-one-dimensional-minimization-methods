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
public class CubicInterpolation {
    
    // approximate the limit
    private static final double DX = 1e-4;
    
    public void run(Function f, double x1, double x2, double x3) {
        this.run(f, x1, x2, x3, 1e-5);
    }
    
    public void run(Function f, double x1, double x2, double x3, double tol) {
        Stopwatch timer = new Stopwatch();
        
        double fp1, fp2, fp3, beta, gamma, theta, psi, a3, a2, a1, m, x, xbar, fbar, xm, fm, x0 = 1e99;
        Function fp = derive(f);
        fp1 = fp.solve(x1);
        fp2 = fp.solve(x2);
        fp3 = fp.solve(x3);
                
        do {
            beta = (f.solve(x2) - f.solve(x1) + fp1*(x1-x2))/Math.pow(x1-x2, 2);
            gamma = (f.solve(x3) - f.solve(x1) + fp1*(x1-x3))/Math.pow(x1-x3, 2);
            theta = (2*x1*x1 - x2*(x1+x2))/(x1-x2);
            psi = (2*x1*x1 - x3*(x1+x3))/(x1-x3);

            a3 = (beta-gamma)/(theta-psi);
            a2 = beta - theta * a3;
            a1 = fp1 - 2*a2*x1 - 3*a3*x1;

            x = (1/3*a3)*(-a2 + Math.sqrt(a2*a2 - 3*a1*a3));
            xbar = -a2/3*a3;
            fbar = f.solve(xbar);
        
            if (fp1 <= fp2 && fp1 <= fp3) {
                m = 1;
            } else if (fp2 <= fp3 && fp2 <= fp1) {
                m = 2;
            } else {
                m = 3;
            }
            x0 = xbar;
            xm = xbar;
            fm = fbar;
            if (m == 1) fp1 = fp.solve(xbar);
        } while (Math.abs(xbar- x0) >= tol);
        
        System.out.printf(" x∗ = %f and f(x∗) = %f", xbar, fbar);
        
        double time = timer.elapsedTime();
        System.out.printf(" (Finished in %.6f seconds)\n", time);
    }
    
    /**
     * @param f f(x), the function to derive
     * @return f'(x), the derivative of the f(x)
     */
    private static Function derive(Function f) {
        return (x) -> (f.solve(x + DX) - f.solve(x)) / DX;
    }
}
