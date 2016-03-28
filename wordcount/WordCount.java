import java.io.FileInputStream;
import java.util.*;
import java.io.IOException;

public class WordCount {

	public static void main(String args[]) throws IOException
	{
		FileInputStream fin= new FileInputStream("secondtonone.txt");
		Scanner fileInput= new Scanner(fin);

		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();

		while(fileInput.hasNext())
		{
			String nextWord = fileInput.next();
			if(words.contains(nextWord))
			{
				int index=words.indexOf(nextWord);
				count.set(index,count.get(index)+1);
			}
			else
			{
				words.add(nextWord);
				count.add(1);
			}
		}
		fileInput.close();
		fin.close();

		
		int a=words.size();
		String words1[]=new String[a];
		int count1[]=new int[a];
		for(int i=0;i<a;i++)
		{
			words1[i]=words.get(i);
			count1[i]=count.get(i);
		}
		for (int i=0;i<a;i++)
		{
			for (int j=0; j< a-1;j++)
			{
				int temp;
				String temp1; 
				if(count1[j]>count1[j+1])
				{
					temp=count1[j];
					count1[j]=count1[j+1];
					count1[j+1]=temp;
					temp1=words1[j];
					words1[j]=words1[j+1];
					words1[j+1]=temp1;
				}
			}
		}
		for (int i=0; i< a;i++)
		{
			System.out.println(words1[i] + " occurred " + count1[i] + "time(s)");
		}
	}
}