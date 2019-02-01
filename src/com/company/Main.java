package com.company;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Color Converter\n\nPlease enter which color type you would like to input by typing 1-3:\n\n1)Color Name (From List}\n2)Hexadecimal Value\n3)RGB Triplet");


        //System.out.println("RGB Triplet: (" + function.hextoRGB("4d567A") + ")");
        //System.out.println("Hex Code: " + function.RGBtoHex(18,10,143));


        Scanner kbin = new Scanner(System.in);
        int input;

        while (true)
        {
            try {
                input = Integer.parseInt(kbin.nextLine());
                if (input > 0 && input <4)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid Input. Please chose a number from 1 to 3");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input. Please chose a number from 1 to 3");
            }
        }

        if(input == 1)
        {
            System.out.println("\nInput the name of the color");
            String inName;
            inName = kbin.nextLine();
            while (true)
            {
                if("-1".equals(function.testForHTML(inName,1)))
                {
                    System.out.println("Name not found. Please choose a name from one of the 140 HTML color names.");
                    inName = kbin.nextLine();
                }
                else
                    break;
            }

            System.out.println("\nColor Name: " + inName);
            System.out.println("Hex Code: " + function.testForHTML(inName, 1));
            System.out.println("RGB Triplet: (" + function.hextoRGB((function.testForHTML(inName, 1).replaceAll("#", ""))) + ")");
        }

        if(input == 2)
        {
            System.out.println("\nInput the Hex value of the color");
            String inName;
            inName = kbin.nextLine();

            System.out.println("\nColor Name: "+ ("-1".equals(function.testForHTML(inName.toLowerCase(), 0)) ? "Not Found" : function.testForHTML(inName.toLowerCase(), 0)));
            System.out.println("Hex Code: #"+ inName.toUpperCase());
            System.out.println("RGB Triplet: (" + function.hextoRGB(inName) + ")");
        }

        if(input == 3)
        {
            System.out.println("\nInput the R value of the color:");
            String Rin;
            String Gin;
            String Bin;

            String inName = "";
            Rin = kbin.nextLine();
            System.out.println("The G value:");
            Gin = kbin.nextLine();
            System.out.println("The B Value:");
            Bin = kbin.nextLine();

            System.out.println(Rin + Gin + Bin);
            inName = function.RGBtoHex(Integer.parseInt(Rin), Integer.parseInt(Gin), Integer.parseInt(Bin));
            //inName = function.RGBtoHex(1, 3, 4);

            System.out.println("\nColor Name: "+ ("-1".equals(function.testForHTML(inName.toLowerCase(), 0)) ? "Not Found" : function.testForHTML(inName.toLowerCase(), 0)));
            System.out.println("Hex Code: #"+ inName.toUpperCase());
            System.out.println("RGB Triplet: (" + function.hextoRGB(inName) + ")");
        }



        //System.out.println("RGB Triplet: (" + function.hextoRGB("4d567A") + ")");
        //System.out.println("Hex Code: " + function.RGBtoHex(77,86,122));

        //System.out.println(function.testForHTML("Silver", 1));
        //function.testForHTML("0073cf", 0);

    }
}
