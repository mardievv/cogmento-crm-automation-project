package com.cogmento.utils;

public class CommonUtils {


    /**
     * This method generates a random number from min argument to max argument
     * @param min
     * @param max
     * @return
     */
    public static int generateRandomNumber(int min, int max){
        return (int)(Math.random() * ((max-min) + 1 )) + min;
    }
}
