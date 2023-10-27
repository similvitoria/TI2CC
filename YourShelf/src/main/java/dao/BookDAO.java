package dao;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

import model.Book;

public class BookDAO extends DAO{
    /**
     * Default constructor: Initializes a connection to the database.
     */
    public BookDAO() {
        super();
        connect();
    }

    /**
     * Finalizes the database connection when collected by the Garbage Collector.
     */
    protected void finalize() {
        close();
    }

    public boolean insert(Book book) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();

            final List<String> authors = book.getAuthor().stream().map(author ->  author).collect(Collectors.toList());
            final String formatedAuthors = String.join(",", authors);
            final String authorsFormattedQuery = "Array["+ formatedAuthors +"]";
            
            String query = "INSERT INTO livros (id, title, author, publisher, publishedDate, pagesNumber, imageLink, previewLink, description, listId) VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s', NULL)";
            query = String.format(query, book.getId(), book.getTitle(), authorsFormattedQuery, book.getPublisher(), book.getPublishedDate(), book.getPagesNumber(), book.getImageLink(), book.getPreviewLink(), book.getDescription()); 
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

        /**
     * Inserts a new user into the database.
     *
     * @param book object to be inserted.
     * @return True if the insertion is successful, false otherwise.
     */
    public boolean insert(Book book, String listId) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();

            final List<String> authors = book.getAuthor().stream().map(author ->  author).collect(Collectors.toList());
            final String formatedAuthors = String.join(",", authors);
            final String authorsFormattedQuery = "Array["+ formatedAuthors +"]";

            String query = "INSERT INTO livros (id, title, author, publisher, publishedDate, pagesNumber, imageLink, previewLink, description, listId) VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s')";
            query = String.format(query, book.getId(), book.getTitle(), authorsFormattedQuery, book.getPublisher(), book.getPublishedDate(), book.getPagesNumber(), book.getImageLink(), book.getPreviewLink(), book.getDescription(), listId); 
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    // /**
    //  * Retrieves a book by their ID from the database.
    //  *
    //  * @param BookID ID of the book to retrieve.
    //  * @return A Book object if found, or null if not found.
    //  */
    // public Book get(String BookID) {
    //     //data
    //     Book book = null;
    //     try {
    //         Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    //         String query = "SELECT * FROM livros WHERE BookID=" + BookID;
    //         ResultSet rs = st.executeQuery(query);
    //         if(rs.next()){
    //             book = new Book(rs.getString("BookID"), rs.getString("Name"), rs.getString("Author"), rs.getString("Genre"), rs.getInt("Page"), rs.getString("ListID"));            }
    //         st.close();
    //     } catch (Exception e) {
    //         System.err.println(e.getMessage());
    //     }
    //     return book;
    // }


    // /**
    //  * updates a book by their ID from the database.
    //  *
    //  * @param book object to be updated.
    //  * @return True if the update was successful, false otherwise.
    //  */
    // public boolean update(Book book) {
    //     //data
    //     boolean status = false;
    //     try {
    //         Statement st = connection.createStatement();
    //         String query = "UPDATE livros SET Name = '" + book.getName() + "', Author = '" + book.getAuthor() + "', Genre = '" 
    //         	    + book.getGenre() + "', Page = '" + book.getPage() + "'" + "', ListID = '" + book.getListID() + "'"
    //                 + " WHERE BookID = " + book.getId();
    //         st.executeUpdate(query);
    //         st.close();
    //         status = true;
    //     } catch (SQLException u) {
    //         throw new RuntimeException(u);
    //     }
    //     return status;
    // }

    /**
     * deletes a book by their ID from the database.
     *
     * @param BookID object to be updated.
     * @return True if the exclusion was successful, false otherwise.
     */
    public boolean delete(String BookID) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();
            String query = "DELETE FROM livros WHERE BookID = %s";
            query = String.format(query, BookID);
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}