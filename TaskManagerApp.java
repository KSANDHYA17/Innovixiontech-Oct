import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private int priority;
    private String dueDate;

    public Task(String title, String description, int priority, String dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nPriority: " + priority + "\nDue Date: " + dueDate;
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ":\n" + tasks.get(i) + "\n");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Due Date: ");
                    String dueDate = scanner.nextLine();

                    Task task = new Task(title, description, priority, dueDate);
                    taskManager.addTask(task);
                    System.out.println("Task added.");
                    break;

                case 2:
                    taskManager.listTasks();
                    break;

                case 3:
                    System.out.print("Enter the index of the task to remove: ");
                    int index = scanner.nextInt();
                    taskManager.removeTask(index - 1);
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
