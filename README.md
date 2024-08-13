# Tawjihi Records Management System
## COMP242 Data Structure project
## Project Summary
This project implements a sorted singly linked list data structure to manage and operate on Tawjihi records from the West Bank and Gaza regions. The system allows for the insertion, deletion, and search of student records, as well as advanced data analysis functions. The project is implemented in Java and includes a graphical user interface (GUI) for easy interaction with the data.

Project Details
Input Data
The project utilizes two input files: WestBank_2022.csv and Gaza_2022.csv. Each file contains Tawjihi records for students, with each record consisting of a seat number, branch (Literary or Science), and average grade. These records are loaded into a sorted singly linked list structure, allowing for efficient operations on the data.

Key Features
Switching Between Regions and Branches

The GUI provides options to switch between West Bank and Gaza data, as well as between Literary and Science branches. All subsequent operations are performed on the selected dataset.
Insert New Record

Users can insert a new Tawjihi record into the linked list, maintaining the list's sorted order. The sorting criteria (seat number, branch, or average) are determined to facilitate further operations.
Delete Record

The system allows for the deletion of a specific Tawjihi record using the student's seat number.
Search for Record

Users can search for a specific Tawjihi record by entering the seat number, quickly retrieving the associated student's information.
Display Top 10 Students

The system can display the top 10 students based on their average grades. This feature considers ties in grades and handles repetitive averages effectively.
Calculate and Display Mean

The system calculates and displays the mean (average) grade of the selected dataset.
Calculate and Display Mode

The mode average, representing the most common grade in the dataset, is calculated and displayed.
Grade Distribution Analysis

Users can input a specific grade threshold, and the system will return the number and percentage of students whose grades are above or equal to that threshold.
