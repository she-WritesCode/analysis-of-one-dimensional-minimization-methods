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
    private static final FibonacciSearch fibonacciSearch = new FibonacciSearch();
    private static final GoldenSectionSearch goldenSectionSearch = new GoldenSectionSearch();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        Function func1 = (double x) -> { return 0.65 - (0.75/(1 + x*x)) - 0.65 * Math.atan(1/x); }; // 6, 0, 3
        Function func2 = (double x) -> { return x*x - 4*x + 1; }; // 6, 0, 5
        Function func3 = (double x) -> { return (-5*Math.pow(x, 5)) + (4 * Math.pow(x, 4)) - (12*Math.pow(x, 3)) + (11*x*x) - (2*x) + 1; }; // 6, 1, 3
        Function func4 = (double x) -> { return ((Math.pow(x, 3)/3) - (x*x)/2 - (x) - 1); }; // 6, 1, 2
        Function func5 = (double x) -> { return (Math.pow(x, 3) + 54)/x; }; // 6, 1, 3
        Function func6 = (double x) -> { return Math.abs((x-1)/4)+Math.abs(Math.sin(Math.PI*(1+((x-1)/4))))+1; }; // 6, 1, 3
        
//        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<< Function 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        fibonacciSearch.run(func1, 0, 3);
//        goldenSectionSearch.run(func1, 0, 3);
//        
//        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<< Function 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        fibonacciSearch.run(func2, 0, 5);
//        goldenSectionSearch.run(func2, 0, 5);
        
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<< Function 3 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        fibonacciSearch.run(func3, -0.5, 0.5);
        goldenSectionSearch.run(func3, -0.5, 0.5);
        
//        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<< Function 4 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        fibonacciSearch.run(func4, 1, 2);
//        goldenSectionSearch.run(func4, 1, 2);
//        
//        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<< Function 5 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        fibonacciSearch.run(func5, 1, 3);
//        goldenSectionSearch.run(func5, 1, 3);

        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<< Function 6 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        fibonacciSearch.run(func6, -3, 3);
        goldenSectionSearch.run(func6, -3, 3);
    }
    
}
