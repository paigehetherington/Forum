import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vajrayogini on 2/11/16.
 */
public class Forum {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = readFile();





        Scanner consoleScanner = new Scanner(System.in);

        int replyId = -1;
        while (true) {
            //loop over posts and print the ones with the right replyId
            printPosts(posts, replyId); //method defined below outside main method
            //ask the user to type a new reply id
            System.out.println("Type the id you want to see replies to:");
            replyId = Integer.valueOf(consoleScanner.nextLine());

        }



    }

    public static ArrayList<Post> readFile() throws FileNotFoundException { //read all the posts into memory (line by line)
        ArrayList<Post> posts = new ArrayList<>();
        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine(); // grab a line and read it;
            String[] columns = line.split("\\|"); //to split 3 parts. escape escape character \\.gives array with 3 things
            Post post = new Post(Integer.valueOf(columns[0]),columns[1], columns[2]); //convert string to int
            posts.add(post); //put into array list

        }
        return posts;
    }
    public static void printPosts(ArrayList<Post> posts,int replyId) {
        int id = 0;
        for (Post post : posts) {
            if (post.replyId == replyId) {
                System.out.printf("(%d) %s by %s\n", id, post.text, post.author);
            }
            id++;
        }
    }
}
