/*
 * Copyright (C) 2026 Alonso del Arte
 *
 * This program is free software; you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation; either version 2 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple 
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package clipboardops;

import java.awt.datatransfer.Clipboard;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import randomness.RandomProvider;

/**
 * Tests of the MockClipboard class.
 * @author Alonso del Arte
 */
public class MockClipboardTest {
    
    @Test
    public void testGetName() {
        System.out.println("getName");
        int threshold = RandomProvider.nextInt(16) + 4;
        for (int i = 1; i < threshold; i++) {
            Clipboard instance = new MockClipboard();
            String expected = "Mock Clipboard #" + i;
            String actual = instance.getName();
            assertEquals(actual, expected);
        }
    }
    
}
