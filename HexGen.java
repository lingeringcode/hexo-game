import java.util.Random;

/**
 * The HexGen class _____
 * 
 * @author Chris Lindgren
 * @version 1.0
 */
public class HexGen
{
    public String hexoWord = "";
    
    /**
     * The create method generates the random hexadecimal number.
     * 
     */
    public String create()
    {
        // put your code here
        final int LENGTH = 5;
        
        Random rand = new Random();
        hexoWord = Integer.toHexString(rand.nextInt(Integer.parseInt("FFFFF", 16))).toUpperCase();
        //int valueHex = rand.nextInt(15);
        
//         for(int i = 0; i != LENGTH; i++)
//         {   
//             //generates random 5-digit hexdecimal number
//             hexoWord = Integer.toHexString(rand.nextInt(Integer.parseInt("FFFFF", 16))).toUpperCase();
//         }
        
        // hex = hexoWord;
        
        System.out.println(hexoWord);
        return hexoWord;
     }
        
//     /**
//     * This toHexString accessor method retrieves the suit variable for the equals method.
//     * 
//     * @return   hexoWord - variable representing the HexGen classes randomly generated hexadecimal number.      
//     */
//     public String getHex()
//     {
//         return hexoWord;
//     }
}
