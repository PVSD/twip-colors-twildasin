package com.company;

import java.util.Objects;

/**
 * Created by tw073 on 1/29/19.
 */
public class function {

    public static int dectoBin (int a)
    {
        int in = a;
        StringBuffer binOut = new StringBuffer();
        double test;
        for(int i = 8; i >= 0; i--)
        {
            test = Math.pow(2, i);
            if(in - test >= 0)
            {
                binOut.append(1);
                in = in - (int)test;
            }
            else
            {
                binOut.append(0);
            }
        }
        return Integer.parseInt(binOut.toString());
    }
    public static int bintoHex (int a)
    {
        String val = Integer.toString(a);
        String test = "";
        //Makes sure the inputted binary chain has a length that is a multiple of 4.
        //If it is not, adds the correct amount of leading zeros to the binary chain.
        val = ((val.length() % 4 == 1) ? "000" : "" ) + val;
        val = ((val.length() % 4 == 2) ? "00" : "" ) + val;   //Ternary operators
        val = ((val.length() % 4 == 3) ? "0" : "" ) + val;
        System.out.println(val);
        return 2;
    }

    public static int bintoDec (String a)
    {
        int out = 0;
        String test = a;
        for(int i = 0; i < a.length(); i++)
        {
            if(Objects.equals(test.substring(test.length() -1, test.length()), "1"))
            {
                out = out + (int)Math.pow(2, i);
            }
            test = test.substring(0, test.length()-1);
        }
        return out;
    }
}
