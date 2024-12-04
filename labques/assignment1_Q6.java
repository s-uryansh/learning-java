package labques;

public class assignment1_Q6 {
    public static void main(String[] args){
    long currentTime = System.currentTimeMillis();
    
    long sec = (currentTime/1000) % 60;
    long min = (currentTime / (1000 * 60)) % 60;
    long hrs = (currentTime / (1000 * 60 * 60)) % 24;
    //Converting time to Indian Standard Times
    adjustToIST(hrs, min, sec);
    
    }

    public static void adjustToIST(long hrs, long min , long sec) {
    hrs = (hrs + 5) % 24;
    min = (min + 30) % 60;
    if (min >= 60) {
        hrs = (hrs + 1) % 24;
        min -= 60;
    }
    System.out.println(hrs + ":" + min + ":" + sec);
}
} 
