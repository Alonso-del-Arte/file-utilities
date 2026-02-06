/*
 * Copyright (C) 2026 Alonso del Arte
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
package fileops;

import java.io.File;
import java.io.FileNotFoundException;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import randomness.RandomProvider;

/**
 * Tests of the PlainTextRewriter class.
 * @author Alonso del Arte
 */
public class PlainTextRewriterNGTest {
    
    @Test
    public void testRewriteNoRewriteNeeded() {
        int length = RandomProvider.nextInt(5, 25);
        String expected = RandomProvider.nextASCIILine(length);
        String actual = PlainTextRewriter.rewrite(expected);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the rewrite function, of the PlainTextRewriter class.
     */
    @Test(enabled = false)
    public void testRewrite() {
        System.out.println("rewrite");
        int length = RandomProvider.nextInt(5, 25);
        String preliminary = RandomProvider.nextASCIILine(length);
        char[] value = preliminary.toCharArray();
        int bound = value.length;
        int replacementIndex = RandomProvider.nextInt(bound);
        char controlChar = (char) RandomProvider.nextInt(' ');
        value[replacementIndex] = controlChar;
        String s = new String(value);
        char controlCharPicture = (char) (controlChar + 0x2400);
        value[replacementIndex] = controlCharPicture;
        String expected = new String(value);
        String actual = PlainTextRewriter.rewrite(s);
        String message = "Character '" + controlChar 
                + "' should be replaced with '" + controlCharPicture + "'";
        assertEquals(actual, expected, message);
    }

    /**
     * Test of main method, of class PlainTextRewriter.
     */
    @Test(enabled = false)
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PlainTextRewriter.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
