package com.main;

import com.client.Client;
import com.restaurant.Robot;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Robot robot = Robot.getInstance();
        for (int i = 0; i < 50; i++) {
            (new Thread(new Client())).start();
        }
        (new Thread(robot)).start();
        if(Thread.activeCount() == 5) {
            robot.setAmSlaving(false);
        }
    }
}
