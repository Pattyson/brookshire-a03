/*
 *  UCF CIS3360 Fall 2021 PA 1
 *  Copyright 2021 Patrick Brookshire
 */

import java.io.*;


class VigenereCipher{

    int size = 512;

    public String encrypt(String plainText, String key){

        char ChararcterKey;
        char ChararacterText;
        String EncrptedText = "";

        int keyLength = key.length();
        for (int i = 0, j = 0; i < plainText.length(); i++) {

            ChararacterText = plainText.charAt(i);
            // getting charcter of plainText
            ChararcterKey = key.charAt(j);
            // getting character of key

            EncrptedText += (char)((ChararacterText + ChararcterKey - 2 * 97) % 26 + 97);
            //Value  'a' = 97. Formula for vigenere cipher text

            j = ++j % keyLength;
            // updates j value if equal to key length to make 0.

        }
        return EncrptedText;
    }
}

class vigenere {

    public static void main(String args[]) {

         String key = "";
         String str = "", plainText = "";
         String fstr;

            try
            { File file = new File("E:\\key.txt");

                BufferedReader br = new BufferedReader(new FileReader(file));
                // Reading key file

            while ((fstr = br.readLine()) != null) {

                key += fstr.replaceAll("[^A-Za-z]", "").toLowerCase();
                //using regex expression to remove non-alphabetic characters
                //and convert them to lower case

            }

            file = new File("E:\\plaintext.txt");
            br = new BufferedReader(new FileReader(file));
            // Reading plain text file


            while ((fstr = br.readLine()) != null) {
                str += fstr.replaceAll("[^A-Za-z]", "").toLowerCase();
            }

            // If plain text file length grater than 512 then truncate data.
            if(str.length()>512){
                plainText = str.substring(0,512);
            }

            // else if less than 512 then add padding x
            else if(str.length() < 512) {
                while(true){
                    if(str.length()==512)
                        break;
                    str += "x";
                }
                plainText = str;
            }

            VigenereCipher cipher = new VigenereCipher();
            String encrptText = cipher.encrypt(plainText, key);

            //print data 80 characters per line
            for(int i=0; i< encrptText.length() ; i=i+80)
                System.out.println(encrptText.substring(i, Math.min(encrptText.length(),i+80)));

        }

        catch(Exception ex){

        }
    }
}