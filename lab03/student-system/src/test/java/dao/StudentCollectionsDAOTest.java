/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import domain.Student;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** StudentCollectionsDAOTest.java
 *  INFO202 Lab03
 *
 *  An automated test for the StudentCollectionsDAO class. 
 *@author Zac Seales - 6687905
 */
public class StudentCollectionsDAOTest {
    
    private StudentCollectionsDAO studentList;
    private Student s1;
    private Student s2;
    private Student s3;
    
    @BeforeEach
    public void setUp() {
        studentList = new StudentCollectionsDAO();
        
        s1 = new Student(1234, "Student One", "Computer Science");
        s2 = new Student(2468, "Student Two", "Economics");
        s3 = new Student(5432, "Student Three", "Computer Science");
        
        studentList.save(s1);
        studentList.save(s2);
    }
    
    @AfterEach
    public void tearDown() {
        //remove test values from the static collection
        studentList.delete(s1);
        studentList.delete(s2);
        studentList.delete(s3);
    }

    @Test
    public void testSave() {
        // make sure that s3 does not already exist
        assertThat(studentList.getAll(), not(hasItem(s3)));
        assertThat(studentList.getAll(), hasSize(2));

        // add s3
        studentList.save(s3);

        // check that s3 was added
        assertThat(studentList.getAll(), hasItem(s3));
        assertThat(studentList.getAll(), hasSize(3));
        
    }

    @Test
    public void testDelete() {
         // make sure that s1 does already exist
        assertThat(studentList.getAll(), hasItem(s1));
        assertThat(studentList.getAll(), hasSize(2));

        // delete it
        studentList.delete(s1);

        // make sure that it is gone
        assertThat(studentList.getAll(), not(hasItem(s1)));
        assertThat(studentList.getAll(), hasSize(1));
    }

    @Test
    public void testGetAll() {
        assertThat(studentList.getAll(), hasSize(2));
        assertThat(studentList.getAll(), hasItem(s1));
        assertThat(studentList.getAll(), hasItem(s2));
    }

    @Test
    public void testGetMajors() {
        assertThat(studentList.getMajors().size(), is(2));
        assertThat(studentList.getMajors(), hasItem("Computer Science"));
        assertThat(studentList.getMajors(), hasItem("Economics"));
    }

    @Test
    public void testGetByID() {
        assertThat(studentList.getByID(1234), is(s1));
        assertThat(studentList.getByID(2468), is(s2));
    }
    
}
