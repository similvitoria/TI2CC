package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Lists;

public class ListDAO extends DAO
{
    /**
     * Default constructor: Initializes a connection to the database.
     */
    public ListDAO()
    {
        super();
        connect();
    }

    /**
     * Finalizes the database connection when collected by the Garbage Collector.
     */
    protected void finalize() {
        close();
    }

    /**
     * Inserts a new list into the database.
     *
     * @param list object to be inserted.
     * @return True if the insertion is successful, false otherwise.
     */
    public boolean insert(Lists list)
    {
        //data
        boolean status = false;
        try
        {
            Statement st = connection.createStatement();
            String query = "INSERT INTO listas (ListID, Name, UserID) "
                    + "VALUES ('"+ list.getListId()+ "', '" + list.getName() + "', '"
                    + list.getId() + "' );";
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u)
        {
            throw new RuntimeException(u);
        }
        return status;
    }

    /**
     * Retrieves a list by their ID from the database.
     *
     * @param ListID ID of the List to retrieve.
     * @return A List object if found, or null if not found.
     */
    public Lists get(String ListID)
    {
        //data
        Lists list = null;
        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM listas WHERE ListID='%s'";
            query = String.format(query, ListID);
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                list = new Lists(rs.getString("ListID"), rs.getString("Name"), rs.getString("UserID"));}
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static List<Lists> getAllLists(String userID) {
        List<Lists> lists = new ArrayList<>();
        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM listas WHERE UserID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userID);

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println(rs.toString());
            while(rs.next()){
                Lists list = new Lists(rs.getString("ListID"), rs.getString("Name"), rs.getString("UserID"));
                lists.add(list);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return lists;
    }

    /**
     * updates a list by their ID from the database.
     *
     * @param list object to be updated.
     * @return True if the update was successful, false otherwise.
     */
    public boolean update(Lists list)
    {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();
            String query = "UPDATE listas SET Name = '" + list.getName() + " WHERE ListID = " + list.getListId();
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u)
        {
            throw new RuntimeException(u);
        }
        return status;
    }

    /**
     * deletes a list by their ID from the database.
     *
     * @param ListID object to be updated.
     * @return True if the exclusion was successful, false otherwise.
     */
    public boolean delete(int ListID) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();
            String query = "DELETE FROM listas WHERE ListID = " + ListID;
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    


}

