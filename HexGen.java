import java.util.Random;

/**
 * The HexGen class generates the 5 digit hexadecimal number for the HexoGame class.
 * 
 * @author Chris Lindgren
 * @version 1.0
 */
public class HexGen
{
    private String hexoWord;
    
    /**
     * The create method generates the random hexadecimal number.
     * 
     */
    public static String create()
    {
        String hexoWord = (String) randomHex();
        
        //initialize original hexoWord characters
        char ch1 = hexoWord.charAt(0);
        char ch2 = hexoWord.charAt(1);
        char ch3 = hexoWord.charAt(2);
        char ch4 = hexoWord.charAt(3);
        char ch5 = hexoWord.charAt(4);
        
        while(ch1 == ch2 || ch1 == ch3 || ch1 == ch4 || ch1 == ch5 || ch2 == ch3 || ch2 == ch4 || ch2 == ch5
        || ch3 == ch4 || ch3 == ch5 || ch4 == ch5)
        {
            hexoWord = randomHex();
            ch1 = hexoWord.charAt(0);
            ch2 = hexoWord.charAt(1);
            ch3 = hexoWord.charAt(2);
            ch4 = hexoWord.charAt(3);
            ch5 = hexoWord.charAt(4);
        }
        
        return hexoWord;
     }
    
    /**
    * This method overrides the Object class clone method.
    * 
    * @return   duplicate - this clone object of the Card object maintains encapsulation
    */
    public static String randomHex()
    {
        Random rand = new Random();
        String hexoWord = Integer.toHexString(rand.nextInt(Integer.parseInt("FFFFF", 16))).toUpperCase();
        
        return hexoWord;
    }
}
