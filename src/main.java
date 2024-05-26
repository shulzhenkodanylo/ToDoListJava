import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    static ArrayList<String> tasksList = new ArrayList<>();

    public static String scanning(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String commandChooser(){
        System.out.println("    Commands    \n-add -remove -done -edit -open ");
        return scanning();
    }

    public static void taskListPrinter(ArrayList<String> tasksList){
        for (int i =0; i < tasksList.size() ; i++){
            System.out.println( (i + 1) + ")" +tasksList.get(i));
        }
    }

    public static void addTask(ArrayList<String> tasksList){
        System.out.println("Enter a task to add: ");
        String taskToAdd = scanning();
        tasksList.add(taskToAdd);
        System.out.println(tasksList);

    }

    public static void main(String[] args){
        for(;;){
            switch (commandChooser()){
                case "-add":
                    addTask(tasksList);
                    break;
                case "-remove":
                    break;
                case "-done":
                    break;
                case "-edit":
                    break;
                case "-open":
                    taskListPrinter(tasksList);
                    break;
                case "-quit":
                    return;
                default:
                    System.out.println("Incorrect input!!!");
            }
        }
    }

}