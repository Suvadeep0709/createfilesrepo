package mypackage;

import java.io.FileWriter;
import java.util.Scanner;

public class MyClass {
	static String path="C:\\Users\\DEVRAJ\\Desktop\\Suvadeep";

	public static void main(String[] args) 
	{
		
		 createFiles();

	}
	public static void createFiles()
	{
		try 
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter file name");
		fileName=obj.nextLine();
		int linesCount;
		System.out.println("Enter number of lines ");
		linesCount=Integer.parseInt(obj.nextLine());
		FileWriter mywriter = new FileWriter(path+"\\"+fileName);
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("enter the line");
			mywriter.write(obj.nextLine()+"\n");
		}
		System.out.println("File created succesfully");
		mywriter.close();
		obj.close();
		}
		catch(Exception Ex)
		{
			System.out.println("Some error occured , please contact admin");
		}
		
	}

}
