package model;
public class Lists {
    //Attributes representing user data -> using postgresql table 'user'
    private String ListID; //List`s own id
    private String Name; //List Name
    private String UserID; // selected user id

    /**
     * Default constructor.
     */
    public Lists()
    {
        this.UserID = "";
        this.Name = "";
        this.ListID = "";
    }

    /**
     * Constructor using specified values.
     *
     * @param ListID    unique ID of the List.
     * @param Name      List name
     * @param UserID    Selected user id
     */
    public Lists(String ListID, String Name, String UserID)
    {
        this.ListID = ListID;
        this.Name = Name;
        this.UserID = UserID;
    }
    /**
     * Sets the ID of the List.
     *
     * @param ListID unique ID of the List.
     */
    public void setListId(String ListID)
    {
        this.ListID = ListID;
    }
    /**
     * Gets the ID of the List.
     *
     * @return unique ID of the List.
     */
    public String getListId()
    {
        return ListID;
    }

    /**
     * Sets the select user id.
     *
     * @param UserID unique ID of the user
     */
    public void setUserId(String UserID)
    {
        this.UserID = UserID;
    }

    /**
     * Gets the select user id.
     *
     * @return user select id.
     */
    public String getId()
    {
        return UserID;
    }

    /**
     * Sets name of the List.
     *
     * @param Name unique list name.
     */
    public void setName(String Name)
    {
        this.Name = Name;
    }

    /**
     * Gets name of the list.
     *
     * @return unique list name.
     */
    public String getName()
    {
        return Name;
    }

    /**
     *
     * @return string representation of the User object.
     */
    @Override
    public String toString()
    {
        return "List [ListID=" + ListID + ",ListName=" + Name + ", userID=" + UserID + "]";
    }
}