package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by tw073 on 1/29/19.
 */
public class function {


    public static String hextoRGB (String a)
    {
        return Integer.toString(function.hextoDec(a.substring(0,2))) + ", " + Integer.toString(function.hextoDec(a.substring(2, 4))) + ", " + function.hextoDec(a.substring(4, 6));
    }

    public static String RGBtoHex (int a, int b, int c)
    {
        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(c);
        return function.dectoHex(a) + function.dectoHex(b) + function.dectoHex(c);
    }

    private static String dectoHex (int a)
    {
        return function.bintoHex((function.dectoBin(a)));
    }

    private static int hextoDec (String a)
    {
        return function.bintoDec(function.hextoBin(a));
    }

    private static int dectoBin (int a)
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

    private static String bintoHex (int a)
    {
        StringBuffer out = new StringBuffer();
        String val = Integer.toString(a);
        String test = "";
        //Makes sure the inputted binary chain has a length that is a multiple of 4.
        //If it is not, adds the correct amount of leading zeros to the binary chain.
        val = ((val.length() % 4 == 1) ? "000" : "" ) + val;
        val = ((val.length() % 4 == 2) ? "00" : "" ) + val;   //Ternary operators
        val = ((val.length() % 4 == 3) ? "0" : "" ) + val;


        int add; for(int i = 0; i < val.length(); i = i + 4)
        {
            add = function.bintoDec(val.substring(i, i + 4));
            if(add < 10)
                out.append(Integer.toString(add));
            else
                {
                    switch (add)
                    {
                        case 10 :
                            out.append("A");
                            break;
                        case 11 :
                            out.append("B");
                            break;
                         case 12 :
                             out.append("C");
                             break;
                         case 13 :
                             out.append("D");
                             break;
                         case 14 :
                             out.append("E");
                             break;
                         case 15 :
                             out.append("F");
                             break;
                    }
                }
        }
        //System.out.println("Neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + out);
        String prinout = out.toString();
        if(prinout.length() < 2)
        {
            prinout = "0" + prinout;
        }
        return prinout;
    }

    private static int bintoDec (String a)
    {
        int out = 0;
        String test = a;
        //Tests every position of the binary string. If its a zero, add the corresponding 2 ^ ___ value based on time through the for loop.
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

    private static String hextoBin (String a)
    {
        String apnd;
        StringBuffer out = new StringBuffer();
        String pos;
        boolean pass = true;
        for(int i = 0; i < a.length(); i++)
        {
            pass = true;
            pos = a.substring(i, i+1);
            pos = pos.toUpperCase();
            try
            {
                Integer.parseInt(pos);
            }
            catch (NumberFormatException e)
            {
                pass = false;
                switch (pos)
                {
                    case "A" :
                        out.append("1010");
                        break;
                    case "B" :
                        out.append("1011");
                        break;
                    case "C" :
                        out.append("1100");
                        break;
                    case "D" :
                        out.append("1101");
                        break;
                    case "E" :
                        out.append("1110");
                        break;
                    case "F" :
                        out.append("1111");
                        break;
                }
            }
            if(pass)
            {
                apnd = Integer.toString(function.dectoBin(Integer.parseInt(pos)));


                apnd = ((apnd.length() % 4 == 1) ? "000" : "" ) + apnd;
                apnd = ((apnd.length() % 4 == 2) ? "00" : "" ) + apnd;   //Ternary operators
                apnd = ((apnd.length() % 4 == 3) ? "0" : "" ) + apnd;

                out.append(apnd);

            }
        }
        return out.toString();
    }

    public static String testForHTML (String a, int findTheName) throws IOException
    {

        int place = 0;
        String names [] = new String[865];
        String codes [] = new String[865];

        Scanner sc = new Scanner( new File("MyList.txt"));
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            sc.next();
            names[place] = sc.next();
            codes[place] = sc.next();
            sc.nextLine();
            place++;
        }

        int pos = -1;
        String nName = a;
        nName = nName.toLowerCase();
        nName = nName.replaceAll(" ", "");

        if(findTheName == 1)
        {
            for(int i = 0; i < names.length; i++)
            {
                //System.out.println((((names[i].toLowerCase()).replaceAll(" ","").replaceAll("\"", ""))));
                pos = (nName.equals(((names[i].toLowerCase()).replaceAll(" ","").replaceAll("\"", "")))) ? i : pos;
            }
            if(pos > -1)
            {
                return codes[pos];
                //System.out.println("Hex Code: " + codes[pos]);
            }
            else
                return "-1";
        }
        else
        {
            for(int i = 0; i < names.length; i++)
            {
                pos = (a.equals(codes[i].replaceAll("#", ""))) ? i : pos;
            }
            if(pos > -1)
            {
                return names[pos];
                //System.out.println("Color Name: " + names[pos]);
            }
            else
                return "-1";
        }



    }


}
