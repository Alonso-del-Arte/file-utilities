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

/**
 * WORK IN PROGRESS...
 * The idea here is that this will take a file and copy it to a plain text file 
 * but replacing all ASCII control characters with ASCII control character 
 * "pictures."
 * @author Alonso del Arte
 */
public class PlainTextRewriter {
    
    static char process(char ch) {
        char adjustment = (ch < ' ') ? '\u2400' : '\u0000';
        return (char) (ch + adjustment);
    }
    
    // TODO: Write tests for this
    static String rewrite(String s) {
        return s;
    }
    
    // TODO: Write tests for this
    public PlainTextRewriter(File file) {
        //
    }
    
    // TODO: Write tests for this
    public static void main(String[] args) {
        System.out.println("NOT IMPLEMENTED YET");
    }
    
}
