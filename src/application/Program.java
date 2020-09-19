package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		String path = "/Users/luizclaudiomoraes/temp/votes.csv";
		
		if(path.isEmpty()) {
			System.out.println("Enter file full path: ");
			Scanner sc = new Scanner(System.in);
			path = sc.next();
			sc.close();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
			
				String[] fields = line.split(",");
				int value = Integer.parseInt(fields[1]);
				Integer aux = votes.get(fields[0]);
				value = (aux != null) ?  value + aux : value; 
				votes.put(fields[0], value);
				line = br.readLine();
				
			}
			
			for(String value : votes.keySet()) {
				System.out.println(value + ": " + votes.get(value));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
