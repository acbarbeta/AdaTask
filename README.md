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
