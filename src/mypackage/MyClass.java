package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MyClass 
{
	static final String projectfilespath = "C:\\Users\\DEVRAJ\\Desktop\\Suvadeep";
	static final String errormessage="Some error occured , please contact admin";

	public static void main(String[] args) 
	{
		int ch;
		Scanner obj = new Scanner(System.in);
		try 
		{
		do 
		{
			displayMenu();
			System.out.println("enter your choice");
			ch=Integer.parseInt(obj.nextLine());
			
			if(ch==1)
			{
				displayAllFiles();
			}
			else if (ch==2)
			{
				createFiles();
			}
			else if(ch==3)
			{
				deleteFiles();
			}
			else if(ch==4)
			{
				searchFiles();
				
			}
			else if (ch==5)
				System.exit(0);
			else 
				System.out.println("please enter digits between 1 to 5");
			
		}
		while(ch>0);
		}
		catch(NumberFormatException Ex)
		{
			System.out.println("Please enter only digits");
		}
		
		
		
	}

	public static void displayMenu()
	{
		System.out.println("===========================================================");
		System.out.println("\t\tWelcome to LockedMe.Com");
		System.out.println("\t\tDesigned by Suvadeep Mukherjee");
		System.out.println("============================================================");
		System.out.println("\t\t1.Display all Files");
		System.out.println("\t\t2.Add a new file");
		System.out.println("\t\t3.Delete a file");
		System.out.println("\t\t4.Search for a file");
		System.out.println("\t\t5.exit");
	}
	
	public static void displayAllFiles()
	{
		File file = new File(projectfilespath);
		String[] filelist=file.list();
		
		for (String str:filelist)
		{
			System.out.println(str);
		}
	}
	public static void deleteFiles()
	{
		Scanner obj = new Scanner(System.in);
		String fileName;
		try
			{
				System.out.println("Enter the file name to be deleted");
				fileName=obj.nextLine();
				File file= new File(projectfilespath+"\\"+fileName);
				
				if (file.exists())
				{
					file.delete();
					System.out.println(fileName +" deleted succesfully");
				}
					
					else 
						System.out.println("File do not exist");
		    }
		catch(Exception Ex)
		{
			System.out.println(errormessage);
		}
		
     }
	
	public static void searchFiles()
	{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name to be searched");
		fileName=obj.nextLine();
				
		File directory =new File( projectfilespath);
		String [] flist = directory.list();
		int flag = 0;
        if (flist == null) 
	        {
	            System.out.println("Empty directory.");
	        }
        else 
        {
        	for (int i=0;i<flist.length;i++)
        	{
        		String filename=flist[i];
        		if (filename.equalsIgnoreCase(fileName)) 
        		{
                    System.out.println(filename + " found");
                    flag = 1;
                }
        	}
        		
        }
        if (flag==0)
        {
        	System.out.println("File not found");
        }
	}
	
	public static void createFiles()
	{
		try 
		{
			
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the filename");
		fileName=obj.nextLine();
		int linescount;
		System.out.println("Enter the number of lines");
		linescount=Integer.parseInt(obj.nextLine());
		FileWriter myWriter = new FileWriter(projectfilespath+"\\"+fileName);
		for (int i=1;i<=linescount;i++)
		{
			System.out.println("Enter the line :");
			myWriter.write(obj.nextLine()+"\n");
		}
		
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
		}
		catch(Exception Ex)
		{
			System.out.println(errormessage);
		}
		
	}
}
