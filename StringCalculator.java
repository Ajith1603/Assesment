public class StringCalculator {
    public static int add(String numbers) {
        // If the input string is empty, return 0
        if (numbers.isEmpty()) {
            return 0;
        }
        
        // Split the string by commas
        String[] numStrings = numbers.split(",");
        int sum = 0;

        // Convert each substring to an integer and add to the sum
        for (String numStr : numStrings) {
            sum += Integer.parseInt(numStr);
        }

        return sum;
    }

    public static void main(String[] args) {
        // Example usages
        System.out.println(add(""));        
        System.out.println(add("1"));       
        System.out.println(add("1,5"));    
    }
}
