package com.training.organizer;

import com.training.organizer.controller.Controller;
import com.training.organizer.model.Model;
import com.training.organizer.view.View;

/**
 * Created by Sonya 28.07.2019.
 */
public class App {
    public static void main(String[] args) {

        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
