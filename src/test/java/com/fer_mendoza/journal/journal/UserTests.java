package com.fer_mendoza.journal.journal;

import com.fer_mendoza.journal.JournalApplication;
import com.fer_mendoza.journal.models.User;
import com.fer_mendoza.journal.services.UserSvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = JournalApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {

    String testUsername = "test-user";

    @Autowired
    private UserSvc userSvc;

    @Test
    public void testSaveUser(){
        User user = new User(testUsername,"test-user@email.com","pass");
        User savedUser = userSvc.createOrUpdate(user);
        assertEquals(testUsername,savedUser.getUsername());
    }

    @Test
    public void getUser(){
        User user = new User(testUsername,"test-user@email.com","pass");
        assertEquals(testUsername, userSvc.findByUsername(testUsername).getUsername());
    }

    @Test
    public void getUsers(){
        User user2 = new User(testUsername+"2","test-user2@email.com","pass");
        userSvc.createOrUpdate(user2);
        assertNotNull(userSvc.all());
    }

    @Test
    public void deleteUser(){
        User userToBeDeleted = new User("delete-me", "delete-me@email.com", "pass");
        userSvc.createOrUpdate(userToBeDeleted);
        userSvc.delete(userToBeDeleted.getId());
        assertNull(userSvc.findByUsername("delete-me"));
    }
}