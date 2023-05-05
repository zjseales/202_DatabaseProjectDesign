/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01;

import java.util.*;

/** Student.java
 *  INFO 202 - Lab01
 *
 * Basic domain class to represent a student.
 * @author Zac Seales - 6687905
 */
public class Student {
    
    private String studentId;
    private String name;
    private List<String> papers = new ArrayList<>();
    
    /** Constructor: Initializes a student with the specified
     *  arguments.
     *@param id - the student ID.
     *@param name - the students name.
     */
    public Student(String id, String name){
        studentId = id;
        this.name = name;
    }
    
    /** Returns the ID of this student.
     *@return - the student's ID.
     */
    public String getStudentId() {
        return studentId;
    }
    
    /** Sets the value of this student's ID.
     *@param studentId - the new ID value.
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /** Returns the students name.
     *@return - the student's name
     */
    public String getName() {
        return name;
    }

    /** Sets the Student name to the given
     *  argument.
     *@param name - the Students name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + '}';
    }
    
}//end Student class
