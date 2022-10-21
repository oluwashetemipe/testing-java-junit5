package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController controller;
    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }
    @DisplayName("Test Proper view")
    @Test
    void index(){
        assertEquals("index",controller.index());
        assertEquals("index",controller.index(),"Wrong view returned");
        assertEquals("index",controller.index(),"Another wrong view returned");
    }
    @DisplayName("Test Exception")
    @Test
    void oupsHandler(){
        assertThrows(ValueNotFoundException.class,() ->{controller.oupsHandler();});
    }
    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), ()->{
            Thread.sleep(5000);
        });
        System.out.println("I got here");
    }
    @Test
    void testTimeOutPremptivly(){
        assertTimeoutPreemptively(Duration.ofMillis(100), ()->{
            Thread.sleep(5000);
        });
        System.out.println("I got here 3442");
    }
}