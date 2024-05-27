import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> tasksList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static String scanning() {
        return scanner.nextLine().trim();
    }

    public static int getIndex(String indexString) {
        try {
            return Integer.parseInt(indexString) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + indexString);
            throw new IllegalStateException("You are invalid...");
        }

    }

    public static String commandChooser() {
        System.out.println("    Commands    \n-add -remove -done -edit -open -quit ");
        return scanning();
    }


    public static void taskListPrinter(ArrayList<String> tasksList) {
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println((i + 1) + ")" + tasksList.get(i));
        }
    }

    public static void addTask(ArrayList<String> tasksList) {
        System.out.println("Enter a task to add: ");
        String taskToAdd = scanning();
        tasksList.add(taskToAdd);
        taskListPrinter(tasksList);

    }

    public static void removeTask(ArrayList<String> tasksList) {
        System.out.println("Enter a task index to remove: ");
        String taskIndexToRemove = scanning();
        try {
            tasksList.remove(getIndex(taskIndexToRemove));
            taskListPrinter(tasksList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect index");
        }
    }


    public static void doneTask(ArrayList<String> tasksList) {
        System.out.println("Enter a task index to done: ");
        String taskIndexToDone = scanning();
        String taskToDone = tasksList.get(getIndex(taskIndexToDone));
        if (!taskToDone.contains("- ✅")) {
            tasksList.set(getIndex(taskIndexToDone), taskToDone + "- ✅");
            taskListPrinter(tasksList);
        } else {
            System.out.println("Task was already done or it is a invalid task");
        }

    }

    public static void editTask(ArrayList<String> tasksList) {
        System.out.println("Enter a task index to edit: ");
        String taskIndexToEdit = scanning();
        String taskEdit = scanning();
        try {
            tasksList.set(getIndex(taskIndexToEdit), taskEdit);
            taskListPrinter(tasksList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect index");
        }
    }


    public static void main(String[] args) {
        for (; ; ) {
            switch (commandChooser()) {
                case "-add":
                    addTask(tasksList);
                    break;
                case "-remove":
                    removeTask(tasksList);
                    break;
                case "-done":
                    doneTask(tasksList);
                    break;
                case "-edit":
                    editTask(tasksList);
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