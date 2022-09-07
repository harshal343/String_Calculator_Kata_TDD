import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    StringCalculator strCal =new StringCalculator();

    // Task 1A : TODO: for an empty string, the add method should return 0
    @Test
    void forEmptyStringShouldReturnZero(){
        assertEquals(0,strCal.add(""));
    }

    // Task 1B : TODO: for the given single number, the add method should return the same number.
    @Test
    void oneNumberShouldReturnSameNumber(){
        assertEquals(5,strCal.add("5"));
        assertEquals(1,strCal.add("1"));
    }

    // Task 1C : TODO: for given two numbers, the add method should return their sum.
    @Test
    void sumOfTwoNumbersShouldReturn(){
        assertEquals(14,strCal.add("5,9"));
        assertEquals(100,strCal.add("55,45"));
        assertEquals(63,strCal.add("5,58"));
        assertEquals(3,strCal.add("1,2"));
    }

    //Task 2: TODO: Allow the add method to handle an unknown amount of numbers
    @Test
    void sumOfUnknownAmountOfNumbers(){
        assertEquals(40,strCal.add("25,7,8"));
        assertEquals(26,strCal.add("1,2,3,1,3,1,8,2,5"));
        assertEquals(160,strCal.add("10,50,45,55"));
    }

    //Task 3: TODO: Allow alphabets to be included with numbers. The numeric value for the alphabet would be equal to its position.
    @Test
    void sumOfNumberAndAlphabetPlaceShouldReturn(){
        assertEquals(34,strCal.add("10,k,m"));
        assertEquals(52,strCal.add("12,b,a,z,9,b"));
        assertEquals(120,strCal.add("v,w,x,y,z"));
        assertEquals(7,strCal.add("1,2,a,c"));

    }

    // Task 4: TODO: Calling add with a negative number will throw an exception “Negatives not allowed” - and the negative that was passed.
    @Test
    void shouldThrowExceptionForNegativeNumber(){
        assertThrows(RuntimeException.class,()->strCal.add("3,4,-8"),"Negatives not allowed -8 ");
        assertThrows(RuntimeException.class,()->strCal.add("-6,+2,4,-12"),"Negatives not allowed -6 8-12 ");
        //strCal.add("-6,+2,4,-12");     //this line also gives exception but proper output
    }

    // Task 5: TODO: Numbers bigger than 1000 should be ignored while adding
    @Test
    void numberShouldIgnoredIfGreaterThanThousand(){
        assertEquals(14,strCal.add("5,1,1002,8"));
        assertEquals(700,strCal.add("2221,520,180"));
        assertEquals(206,strCal.add("2,1001,204"));
        assertEquals(2,strCal.add("2,1001"));
    }

    // Task 6: TODO: Allow the add method to handle new lines between numbers (instead of commas)
    @Test
    void shouldHandleNewLinesAndAdd(){
        assertEquals(6,strCal.add("1\n2,3"));
        assertEquals(700,strCal.add("\n500,1541,\n200"));
        assertEquals(805,strCal.add("54,\n\n100\n1,\n650"));
    }
}