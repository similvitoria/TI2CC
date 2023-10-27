package model;
public class User {
    //Attributes representing user data -> using postgresql table 'user'
    private String UserID; //user's own id
    private String Email; //user's email address
    private String Password; //user's password
    private String FirstName; //user's first name
    private String SecondName; //user's last name

    /**
     * Default constructor.
     */
    public User() {
        this.UserID = "";
        this.Email = "";
        this.Password = "";
        this.FirstName = "";
        this.SecondName = "";
    }

    /**
     * Constructor using specified values.
     *
     * @param UserID    unique ID of the user.
     * @param Email user's email address.
     * @param Password   user's password.
     * @param FirstName  user's first name.
     * @param SecondName user's last name.
     */
    public User(String UserID, String Email, String Password, String FirstName, String SecondName) {
        this.UserID = UserID;
        this.Email = Email;
        this.Password = Password;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
    }

    /**
     * Sets the ID of the user.
     *
     * @param UserID unique ID of the user.
     */
    public void setId(String UserID) {
        this.UserID = UserID;
    }

    /**
     * Gets the ID of the user.
     *
     * @return unique ID of the user.
     */
    public String getId() {
        return UserID;
    }

    /**
     * Sets the email address of the user.
     *
     * @param Email user's email address.
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * Gets the email address of the user.
     *
     * @return user's email address.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Sets the password of the user.
     *
     * @param Password user's password.
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Gets the password of the user.
     *
     * @return user's password.
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets the first name of the user.
     *
     * @param FirstName user's first name.
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * Gets the first name of the user.
     *
     * @return user's first name.
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param SecondName user's last name.
     */
    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return user's last name.
     */
    public String getSecondName() {
        return SecondName;
    }

    /**
     *
     * @return string representation of the User object.
     */
    @Override
    public String toString() {
        return "User [UserID=" + UserID + ", Email=" + Email + ", Password=" + Password + ", FirstName=" + FirstName + ", SecondName=" + SecondName + "]";
    }
}
