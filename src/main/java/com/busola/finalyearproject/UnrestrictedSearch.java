/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.busola.finalyearproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Busola Okeowo
 */
public class UnrestrictedSearch {
    double x1; // Initial point
    Function fn;
    List<Double> f = new ArrayList<>(); // list of f
    List<Double> x = new ArrayList<>(); // list of x
    
    public void algorithm(Function fn, double x1, double S /* step size */) {
        x.add(x1);
        int i = 1;
        
        f.add(fn.solve(x.get(0))); // Find f1 = f(x1)
        x.add(x.get(0) + S); // find x2
        f.add(fn.solve(x.get(1))); // Find f2 = f(x2)
        
        boolean case1 = f.get(i) < f.get(i-1); // Case 1
        boolean case2 = f.get(i) > f.get(i-1);
            System.out.println("| i | x | f |  is fi > fi-1 |");
        
        if (case1) {
            System.out.println("f2 < f1");
            boolean condition = (f.get(i) >= f.get(i-1));
            System.out.printf("| %d | %f | %f |  %s |%n", i, x.get(i), f.get(i), condition);    
            i++;
            do {
                x.add(i, x.get(i-1) + (i-1)*S); // find x3
                f.add(i, fn.solve(x.get(i))); // Find f3 = f(x3)
                condition = (f.get(i) >= f.get(i-1));
                System.out.printf("| %d | %f | %f |  %s |%n", i, x.get(i), f.get(i), condition);
                i++;
            } while (!condition);
            
        } else if (case2) {
            while (!((f.get(i-2) < f.get(i-1)) && (f.get(i-2) < f.get(i)))) {
                i++;
                x.add(i, x.get(i-1) - i*S); // find x2
                f.add(fn.solve(x.get(1))); // Find f2 = f(x2)
                System.out.println("f2 > f1");
                System.out.println(i);
            }
            System.out.println(i);
            System.out.println(x);
            System.out.println(f);
        } /*else if (f.get(i) != f.get(i-1)) {
        }*/ else {
            System.out.println(i);
            System.out.println(x);
            System.out.println(f);
        }
    }
    
}
