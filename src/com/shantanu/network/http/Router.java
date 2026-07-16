package com.shantanu.network.http;

import com.shantanu.network.controller.AboutController;
import com.shantanu.network.controller.HomeController;

public class Router {

    public String route(Request request) {

        switch (request.getPath()) {

            case "/":
                HomeController homeController = new HomeController();
                return homeController.home();

            case "/about":
                AboutController aboutController = new AboutController();
                return aboutController.about();

            default:
                return "<h1>404 - Page Not Found</h1>";
        }
    }
}