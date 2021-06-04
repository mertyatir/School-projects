import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
	
	private static final String FileName = "CENG112_HW4_Media.txt";


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = null;
		FileReader fr = null; 
		fr = new FileReader(FileName);
		br = new BufferedReader(fr);
		String sCurrentLine;
		BST binarysearchtree= new BST();
		while ((sCurrentLine = br.readLine()) != null) 
		{
		String[] splitted = sCurrentLine.split(",",-1);
		String mediaType= splitted[0];
		String mediaName=splitted[1];
		int mediaPrice= Integer.valueOf(splitted[2]);
		int mediaYear= Integer.valueOf(splitted[3]);
		String authorName=null,directorName=null,actressName=null,actorName=null;
		if(mediaType.equals("Book")) 
		{
			authorName=splitted[4];
			Book item= new Book();
			item.setAuthorName(authorName);
			item.setMediaName(mediaName);
			item.setMediaPrice(mediaPrice);
			item.setMediaYear(mediaYear);
			binarysearchtree.add(item);
		}
		else if (mediaType.equals("Movie")) 
		{
			directorName=splitted[4];
			actressName=splitted[5];
			actorName=splitted[6];
			Movie item= new Movie();
			if(!actorName.equals("")) 
			{
			item.setActorName(actorName);
			}
			if(!actressName.equals("")) 
			{
			item.setActressName(actressName);
			}
			item.setDirectorName(directorName);
			item.setMediaName(mediaName);
			item.setMediaPrice(mediaPrice);
			item.setMediaYear(mediaYear);
			binarysearchtree.add(item);
		}
	
		}
		br.close();
		

		

		Scanner keyboard= new Scanner(System.in);
		int choice;
		do {
			
			Iterator<IMedia> iterator= binarysearchtree.getInorderIterator();
			LinkedStack<IMedia> stack= new LinkedStack<IMedia>();
			
			System.out.println("1. Print the minimum priced book whose author name is taken from console.\r\n" + 
					"2. Print the maximum priced book whose author name is taken from console.\r\n" + 
					"3. Print the minimum priced movie whose director name is taken from console.\r\n" + 
					"4. Print the maximum priced movie whose director name is taken from console.\r\n" + 
					"5. Print all media whose prices are less or equal than the amount taken from console.\r\n" + 
					"6. Print all media whose prices are greater than the amount taken from console.\r\n" + 
					"7. Print all media in descending order in terms of the price.\r\n" + 
					"8. Print all media in ascending order in terms of the price.\r\n" + 
					"9. Print all books in descending order in terms of the price.\r\n" + 
					"10. Print all books in ascending order in terms of the price.\r\n" + 
					"11. Print all movies in descending order in terms of the price.\r\n" + 
					"12. Print all movies in ascending order in terms of the price.\r\n"
					+"Press -1 to quit");
			
			

			choice=keyboard.nextInt();
			keyboard.nextLine();
			String author;
			String director;
			int price;
			boolean found=false;
			switch (choice) {
			
			case 1:
				System.out.println("Enter a author name");
				author=keyboard.nextLine();
				while(iterator.hasNext()&& found!=true)
				{
					IMedia currentitem=iterator.next();
					if(currentitem.mediaType().equals("Book"))
					{
						Book book=(Book) currentitem;
						if(book.getAuthorName().equals(author)) 
						{
							System.out.println(book.toString());
							found=true;
						}
					}
				}

				break;
			case 2:
				System.out.println("Enter a author name");
				author=keyboard.nextLine();
				while(iterator.hasNext())
				{
					IMedia currentitem= iterator.next();
					stack.push(currentitem);
				}
				while(!stack.isEmpty()&&found==false) 
				{
					IMedia currentitem=stack.pop();
					if(currentitem.mediaType().equals("Book"))
					{
						Book book=(Book) currentitem;
						if(book.getAuthorName().equals(author)) 
						{
							System.out.println(book.toString());
							found=true;
						}
					}
				}
				break;
			case 3:
				System.out.println("Enter a director name");
				director=keyboard.nextLine();
				while(iterator.hasNext()&&found==false) 
				{
					IMedia currentitem=iterator.next();
					if(currentitem.mediaType().equals("Movie"))
					{
						Movie movie=(Movie) currentitem;
						if(movie.getDirectorName().equals(director)) 
						{
							System.out.println(movie.toString());
							found=true;
						}
					}
				}
				
				break;
			case 4:
				System.out.println("Enter a director name");
				director=keyboard.nextLine();
				while(iterator.hasNext())
				{
					IMedia currentitem= iterator.next();
					stack.push(currentitem);
				}
				while(!stack.isEmpty()&&found==false) 
				{
					IMedia currentitem=stack.pop();
					if(currentitem.mediaType().equals("Movie"))
					{
						Movie movie=(Movie) currentitem;
						if(movie.getDirectorName().equals(director)) 
						{
							System.out.println(movie.toString());
							found=true;
						}
					}
				}
				
				break;
			case 5:				
			System.out.println("Enter a price");
			price=Integer.valueOf(keyboard.nextLine());
			while(iterator.hasNext()&&found==false) 
			{
				IMedia currentitem=iterator.next();
	
				if(price>=currentitem.mediaPrice()) 
				{
					System.out.println(currentitem.toString());
				}
				else
					found=true;
			
			}
				
				break;
			case 6:
				System.out.println("Enter a price");
				price=Integer.valueOf(keyboard.nextLine());
				while(iterator.hasNext())
				{
					IMedia currentitem= iterator.next();
					stack.push(currentitem);
				}
				while(!stack.isEmpty()&&found==false) 
				{
					IMedia currentitem=stack.pop();
		
					if(price<currentitem.mediaPrice()) 
					{
						System.out.println(currentitem.toString());
					}
					else
						found=true;
				
				}
				break;
			case 7:
				while(iterator.hasNext())
				{
					IMedia currentitem= iterator.next();
					stack.push(currentitem);
				}
				while(!stack.isEmpty())
				{
					System.out.println(stack.pop().toString());
				}
				break;
			case 8:
				while(iterator.hasNext())
				{
					System.out.println(iterator.next().toString());
				}
				
				break;
			case 9:
				while(iterator.hasNext())
				{
					IMedia currentitem= iterator.next();
					stack.push(currentitem);
				}
				while(!stack.isEmpty())
				{
					IMedia currentitem=stack.pop();
					if(currentitem.mediaType().equals("Book"))
					{
					System.out.println(currentitem.toString());
					}
				}

				break;
			case 10:
				while(iterator.hasNext())
				{
					IMedia currentitem=iterator.next();
					if(currentitem.mediaType().equals("Book"))
					{
					System.out.println(currentitem.toString());
					}
				}
				
				
				break;
			case 11:
				while(iterator.hasNext())
				{
					IMedia currentitem= iterator.next();
					stack.push(currentitem);
				}
				while(!stack.isEmpty())
				{
					IMedia currentitem=stack.pop();
					if(currentitem.mediaType().equals("Movie"))
					{
					System.out.println(currentitem.toString());
					}
				}
				break;
			case 12:
				while(iterator.hasNext())
				{
					IMedia currentitem=iterator.next();
					if(currentitem.mediaType().equals("Movie"))
					{
					System.out.println(currentitem.toString());
					}
				}
				break;

			default:
				break;
			}

		} while (choice!=-1);

		
	
		keyboard.close();

	}

}
