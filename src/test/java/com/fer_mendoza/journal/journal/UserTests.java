package com.fer_mendoza.journal.journal;

import com.fer_mendoza.journal.JournalApplication;
import com.fer_mendoza.journal.models.User;
import com.fer_mendoza.journal.services.UserSvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.security.RunAs;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = JournalApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {
    @Autowired
    private UserSvc userSvc;

    @Test
    public void testSaveUser(){
        User user = new User("fer","fer@email.com","pass");
        User savedUser = userSvc.createOrUpdate(user);
        assertEquals("fer",savedUser.getUsername());
    }
}