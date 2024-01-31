# **AdaTask**

## Introduction
AdaTask is a console-based task manager for work, study, or personal tasks. It allows users to create, edit, and remove tasks, or view all listed tasks in a specific category.
This project was developed by me as a final module assignment for the **<dev>a** course, by [Ada Tech](https://ada.tech/) in partnership with [B3](https://www.b3.com.br/pt_br/para-voce), and is still under development for further improvements.

## 💻 Prerequisites and Technologies Used in the Project
For this project, the IntelliJ IDE was used, along with the following languages and technologies:
- Java 17.0.9;
- Maven 3.9.4;
- Make sure you have a Windows, Linux, or macOS machine;
- Make sure you have read the project documentation.

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

## Application flow
1. **Application Initialization:** the *Main* class serves as the point of interaction between the user and the application. It presents a simple interface (**mainMenu()**), provided by the *controller*, allowing the user to choose the type of task they wish to manage: study, work, or personal.
2. **Action Selection:** after choosing the type of task to manage, the user is presented with a new interface that displays a menu of **possible actions to select**.
3. **Possible actions:**  
3.1. aa
