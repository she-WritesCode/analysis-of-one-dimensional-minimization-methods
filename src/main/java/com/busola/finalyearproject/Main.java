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
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        GoldenSectionSearch goldenSectionSearch = new GoldenSectionSearch();
        QuadraticInterpolation quadraticInterpolation = new QuadraticInterpolation();
        CubicInterpolation cubicInterpolation = new CubicInterpolation();
        
        // TODO code application logic here
        Function func1 = (double x) -> { return 0.65 - (0.75/(1 + x*x)) - 0.65 * Math.atan(1/x); };
        Function func2 = (double x) -> { return x*x - 4*x + 1; };
        
        System.out.println("Fibonacci >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); 
        fibonacciSearch.run(func2, 6, 0, 5);
        
        System.out.println("\nGolden search >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        goldenSectionSearch.run(func2, 0, 5);
        
        System.out.println("\nQuadratic Intepolation >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        quadraticInterpolation.run(func2, 0, 5);
        
        System.out.println("\nCubic Intepolation >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        cubicInterpolation.run(func2, 0, 2.5, 5);
    }
    
}
