package utils;

public class UtilRandNum {
    public static int getRand(int min, int max){
        return (int)(min + Math.random() * (max - min));
    }

    public static int getResultOfDice(){
        return getRand(1, 6);
    }
}
