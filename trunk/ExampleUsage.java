/**
 * Example Usage of the BoundedBufferedReader class
 *
 * Copyright (c) 2011 - Sean Malone
 *
 * The BoundedBufferedReader is published by Sean Malone under the BSD license. You should read and accept the
 * LICENSE before you use, modify, and/or redistribute this software.
 *
 * @author Sean Malone <sean@seantmalone.com>
 * @version 1.1
 */

import java.io.*;

class ExampleUsage 
{
	public static void main(String args[])
	{
		FileReader fReader = null;
		BoundedBufferedReader bbReader = null;
		FileWriter fWriter = null;
		BufferedWriter bWriter = null;
		
		Integer maxLines = 1024;
		Integer maxLineLen = 1024;
	
		if (args.length >= 1)
			maxLines = Integer.parseInt(args[0]);
		if (args.length >= 2)
			maxLineLen = Integer.parseInt(args[1]);
		
		try {
			fReader = new FileReader("TestCase.txt");
			bbReader = new BoundedBufferedReader(fReader, maxLines, maxLineLen);
			
			fWriter = new FileWriter("TestCase_output.txt");
			bWriter = new BufferedWriter(fWriter);
	
			String line;
			while ((line = bbReader.readLine()) != null){ 
				System.out.println (line);
				bWriter.write(line);
				bWriter.newLine();
			}
	
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			try {
				if (bbReader != null) bbReader.close();
			} catch (Exception e){
				System.err.println("Unable to close reader: " + e.getMessage());
			}
			try {
				if (bWriter != null) bWriter.close();
			} catch (Exception e){
				System.err.println("Unable to close writer: " + e.getMessage());
			}
		}
	}
}