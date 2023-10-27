package controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.BookDAO;
import dao.ListDAO;
import model.Book;
import model.Lists;
import spark.Route;
import spark.Request;
import spark.Response;

public class ListController {
    private static ListDAO listDAO = new ListDAO();
    private static BookDAO bookDAO = new BookDAO();

    public static Route inserBookInList = (Request req, Response resp) -> {
        final String listId = req.params("listId");
        final Book rawBookData = Book.fromJsonString(req.body());
        if(listDAO.get(listId) != null) {
            rawBookData.setId(UUID.randomUUID().toString());
            bookDAO.insert(rawBookData, listId);
            System.out.println("inseriu" + rawBookData.toString());
        }
        return null;
    };

    public static Route getListsByUserId = (Request req, Response resp) -> {
        final String userId = req.params("userId");
        List<Lists> lists = ListDAO.getAllLists(userId);
        resp.type("application/json");
        try {
            resp.body(listsToJson(lists));
            return resp;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;  
    };

    public static Route deleteBookFromList = (Request req, Response resp) -> {
        final String bookId = req.params("bookId");
        final boolean isDeleted = bookDAO.delete(bookId);
        if (isDeleted){
            return null;
        }
        resp.status(500);
        return resp;
    };

    private static String listsToJson(List<Lists> lists) throws JsonProcessingException{
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(lists); 
    }
}
