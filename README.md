# **AdaTask**

## Introduction
AdaTask is a console-based task manager for work, study, or personal tasks. It allows users to create, edit, and remove tasks, or view all listed tasks in a specific category.
This project was developed by me as a final module assignment for the **<dev>a** course, by [Ada Tech](https://ada.tech/) in partnership with [B3](https://www.b3.com.br/pt_br/para-voce), and is still under development for further improvements.

## 💻 Prerequisites and Technologies Used in the Project
For this project, the IntelliJ IDE was used, along with the following languages and technologies:
- Java 17.0.9;
- Maven 3.9.4;
- Ensure that you have a Windows, Linux, or macOS machine;
- Ensure that you have read the project documentation.

## 📚 Concepts learned
- Generics
- Object Oriented Programming
    - Interfaces
    - enums
- Java
- ArrayList manipulation
- Java design patterns

## ⚙️ Application Structure
The application is organized into packages, including:
- `controller`: Manages user interaction with the system through the console, processes user commands, and utilizes the Service layer for execution.
- `Domain`: Defines the structure and business rules for tasks, and contains the entities of the project.
- `Repository`: Responsible for the 'persistence' of data in lists, this component offers methods for adding, removing, updating, and searching tasks. It is important to note that the database is simulated using an ArrayList.
- `Service`: Contains the application logic, including task handling operations, and interacts with the Repository layer to perform data operations.

## 🔁 Application flow
1. **Application Initialization:** the *Main* class serves as the point of interaction between the user and the application. It presents a simple interface (**mainMenu()**), provided by the *controller*, allowing the user to choose the type of task they wish to manage: study, work, or personal.
  
2. **Action Selection:** after choosing the type of task to manage, the user is presented with a new interface that displays a menu of **possible actions to select**.
  
3. **Possible actions:**  
3.1. **Create Task:** the user can create personal, work, or study tasks, based on the selection made in **mainMenu()**. Each type of task possesses its own specific attributes. For every task created, a UUID is generated, and the timestamps of creation and last modification are recorded in the **createdAt** and **updatedAt** fields, respectively."  
3.2. **Edit Task:** the user can edit and update the selected task by locating it using its UUID.  
3.3. **Delete Task:** the user can delete the desired task by locating it using its UUID.
3.4. **View Existing Tasks:** the user can view registered tasks from a specific category, as chosen in **mainMenu()**. This functionality allows viewing all the data associated with each registered task.  

4. **Data Persistence:** data simulation of a database is achieved using in-memory lists (ArrayList).

## ▶️ Getting Started
1. Ensure that you satisfy all prerequisites before proceeding.
2. Clone the repository onto your machine:
     ```
        git clone <repo_path>
     ```  
3. Open the project in an IDE (e.g., Eclipse, IntelliJ, VSCode).
4. Navigate to the **`Main`** class and run it
5. The application should now be started. Follow the on-screen instructions to interact with AdaTask.


## 🚩 Future Improvements

