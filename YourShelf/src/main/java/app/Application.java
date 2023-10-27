package app;
import controller.HomePageController;
import controller.IndexController;
import controller.ListController;
import controller.LoginController;
import controller.RegisterController;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/index", IndexController.getIndexPage);

        get("/register", RegisterController.getRegisterPage);

        post("/register", RegisterController.registerUser);

        get("/login", LoginController.getLoginPage);

        post("/login", LoginController.authenticate);

        get("/home", HomePageController.getHomePage);

        post("/home", HomePageController.registerList);

        post("/lists/:listId/books", ListController.inserBookInList);

        post("/lists/users/:userId", ListController.getListsByUserId);

        delete("/lists/books/:bookId", ListController.deleteBookFromList);
    }
}
