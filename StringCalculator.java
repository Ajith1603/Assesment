import java.util.ArrayList;
import java.util.List;
public class StringCalculator 
{
    public int add(String numbers) 
    {
        if (numbers.isEmpty()) 
        {
            return 0;
        }
        String delimiter = ",";
        if (numbers.startsWith("//")) 
        {
            int newlineIndex = numbers.indexOf("\n");
            if (newlineIndex > 0) 
            {
                delimiter = numbers.substring(2, newlineIndex);
                numbers = numbers.substring(newlineIndex + 1);
            }
        }
        String[] numberList = numbers.replace("\n", delimiter).split(delimiter);
        
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : numberList) 
        {
            if (!num.isEmpty()) 
            {
                int value = Integer.parseInt(num);
                if (value < 0) 
                {
                    negatives.add(value);
                }
                total += value;
            }
        }
        if (!negatives.isEmpty()) 
        {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives);
        }
        return total;
    }
    public static void main(String[] args) 
    {
        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.add(""));             
        System.out.println(calculator.add("1"));             
        System.out.println(calculator.add("1,5"));          
        System.out.println(calculator.add("1\n2,3"));       
        System.out.println(calculator.add("//;\n1;2"));     
        try 
            {
            System.out.println(calculator.add("//;\n1;-2"));
            } 
        catch (IllegalArgumentException e) 
            {
            System.out.println(e.getMessage());      
            }
    }
}
