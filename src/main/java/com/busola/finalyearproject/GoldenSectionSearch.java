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
public class GoldenSectionSearch {
    double gr = (Math.sqrt(5) + 1) / 2;
    
    public void run(Function f, double a, double b) {
        this.run(f, a, b, 1e-5);
    }
    
    public void run(Function f, double a, double b, double tol) {
        Stopwatch timer = new Stopwatch();
        double c = b - (b - a) / gr;
        double d = a + (b - a) / gr;
        while (Math.abs(b - a) > tol) {
            if (f.solve(c) < f.solve(d)) {
                b = d;
            } else{
                a = c;
            }
            // We recompute both c and d here to avoid loss of precision which may lead to incorrect results or infinite loop
            c = b - (b - a) / gr;
            d = a + (b - a) / gr;
        }
            
        System.out.printf("point = %f, minimum f(x) = %f", (b + a) / 2, f.solve((b + a) / 2) );
        
        double time = timer.elapsedTime();
        System.out.printf(" (Finished in %.6f seconds)\n", time);
    }
}