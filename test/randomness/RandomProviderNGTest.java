/*
 * Copyright (C) 2025 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package randomness;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.testframe.api.Asserters.assertThrows;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the RandomProvider class.
 * @author Alonso del Arte
 */
public class RandomProviderNGTest {
    
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    
    @Test
    public void testNextInt() {
        System.out.println("nextInt");
        int capacity = 2048;
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            numbers.add(RandomProvider.nextInt());
        }
        int expected = 15 * capacity / 16;
        int actual = numbers.size();
        String msg = "Expected at least " + expected
                + " distinct integers out of " + capacity + ", got " + actual;
        System.out.println(msg);
        assert actual >= expected : msg;
    }
    
    @Test
    public void testNextIntBounded() {
        int capacity = 2048;
        int bound = capacity - RANDOM.nextInt(128);
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            int number = RandomProvider.nextInt(bound);
            String msg = "Pseudorandom number " + number
                    + " should be at least 0 but less than " + bound;
            assert number >= 0 : msg;
            assert number < bound : msg;
            numbers.add(number);
        }
        int expected = capacity / 2;
        int actual = numbers.size();
        String msg = "Expected at least " + expected
                + " distinct integers in the range 0 to " + (bound - 1)
                + " out of " + capacity + ", got " + actual;
        System.out.println(msg);
        assert actual >= expected : msg;
    }
    
    @Test
    public void testNextASCIIChar() {
        System.out.println("nextASCIIChar");
        int expected = 96;
        Set<Character> characters = new HashSet<>(expected);
        for (int i = 0; i < 2048; i++) {
            char ch = RandomProvider.nextASCIIChar();
            String msg = "Pseudorandom character '" + ch
                    + "' should be an ASCII character";
            assert ch >= ' ' : msg;
            assert ch < '\u0080' : msg;
            characters.add(ch);
        }
        int actual = characters.size();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testNextASCIILineRejectsNegativeLength() {
        int length = -RANDOM.nextInt(1024) - 1;
        String msg = "Length " + length + " should have caused an exception";
        Throwable t = assertThrows(() -> {
            String badResult = RandomProvider.nextASCIILine(length);
            System.out.println(msg + ", not given result \"" + badResult 
                    + "\"");
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        String numStr = Integer.toString(length);
        String containsMsg = "Exception message should contain \"" + numStr 
                + "\"";
        assert excMsg.contains(numStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }

    @Test
    public void testNextASCIILineRejectsLengthZero() {
        String msg = "Length 0 should have caused an exception";
        Throwable t = assertThrows(() -> {
            String badResult = RandomProvider.nextASCIILine(0);
            System.out.println(msg + ", not given result \"" + badResult 
                    + "\"");
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        String containsMsg = "Exception message should contain \"0\"";
        assert excMsg.contains("0") : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void testNextASCIILineGivesSpecifiedLength() {
        for (int expected = 1; expected < 81; expected++) {
            String result = RandomProvider.nextASCIILine(expected);
            int actual = result.length();
            String message = "String \"" + result 
                    + "\" should be of specified length " + expected;
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testNextASCIILineGivesStringWithASCIIPrintingCharsOnly() {
        int length = RANDOM.nextInt(16) + 4;
        String result = RandomProvider.nextASCIILine(length);
        char[] characters = result.toCharArray();
        for (char ch : characters) {
            String msg = "Character '" + ch 
                    + "' should be a printing ASCII character";
            assert ch >= ' ' : msg;
            assert ch < '\u007F' : msg;
        }
    }

}
