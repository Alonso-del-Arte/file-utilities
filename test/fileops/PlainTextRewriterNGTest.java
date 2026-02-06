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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the PlainTextRewriter class.
 * @author Alonso del Arte
 */
public class PlainTextRewriterNGTest {
    
    /**
     * Test of rewrite method, of class PlainTextRewriter.
     */
    @Test
    public void testRewrite() {
        System.out.println("rewrite");
        String s = "";
        String expResult = "";
        String result = PlainTextRewriter.rewrite(s);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PlainTextRewriter.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PlainTextRewriter.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
