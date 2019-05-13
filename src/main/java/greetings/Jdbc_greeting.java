package greetings;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Jdbc_greeting {

    final String KOANS_DATABASE_URL = "jdbc:h2:./target/jdbc_greeting";
//    CREATE/ ADD
    final String ADD_A_USER_SQL = "insert into greeting (name, counter) values (?, ?)";

//    READ/ FIND
    final String FIND_A_USER_SQL = "select * from greeting where name = ?";
    final String FIND_USERS_SQL = "select * from greeting";

//    UPDATE
    final String UPDATE_A_USER_SQL = "update greeting SET counter = counter + 1 where name = ?";

//    DELETE
    final String DELETE_A_USER_SQL = "delete from greeting where name = ?";
    final String DELETE_USERS_SQL = "delete from greeting";


//    PREPARED STATEMENTS
    PreparedStatement addAUserPreparedStatement;

    PreparedStatement findAUserPreparedStatement;
    PreparedStatement findAllUsersPreparedStatement;

    PreparedStatement updateAUserPreparedStatement;

    PreparedStatement deleteAUserPreparedStatement;
    PreparedStatement deleteAllUsersPreparedStatement;


    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(KOANS_DATABASE_URL, "sa", "");
        return conn;
    }

    public Jdbc_greeting() throws ClassNotFoundException {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = getConnection();

            addAUserPreparedStatement = conn.prepareStatement(ADD_A_USER_SQL);

            findAUserPreparedStatement = conn.prepareStatement(FIND_A_USER_SQL);
            findAllUsersPreparedStatement = conn.prepareStatement(FIND_USERS_SQL);

            updateAUserPreparedStatement = conn.prepareStatement(UPDATE_A_USER_SQL);

            deleteAUserPreparedStatement = conn.prepareStatement(DELETE_A_USER_SQL);
            deleteAllUsersPreparedStatement = conn.prepareStatement(DELETE_USERS_SQL);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    void addUsers(String name) throws SQLException {
        addAUserPreparedStatement.setString(1, name);
        addAUserPreparedStatement.setInt(2, 1 );
        addAUserPreparedStatement.execute();

    }

    public Map findAUser(String name) throws SQLException {
//        "select * from greeting where name = ?";
        HashMap<String, Integer> userNames = new HashMap<String, Integer>();
        findAUserPreparedStatement.setString(1,name);
        ResultSet rs = findAUserPreparedStatement.executeQuery();
        if(rs.next()){
            int counter = rs.getInt("counter");
            userNames.put(name, counter);
        }
        return userNames;

    }

    public Map findUsers() throws SQLException {
        HashMap<String, Integer> userNames = new HashMap<String, Integer>();

        ResultSet rs = findAllUsersPreparedStatement.executeQuery();
        while (rs.next()){
            //put name & counter in the map
            String name = rs.getString("name");
            int counter = rs.getInt("counter");
            userNames.put(name, counter);
//            System.out.println(rs.getString("name") + "    " + rs.getInt("counter") );
        }

        return userNames;
    }

    public void updateUser(String name) throws SQLException {
        updateAUserPreparedStatement.setString(1, name);
        updateAUserPreparedStatement.executeUpdate();


    }

    public void deleteAUser(String name) throws SQLException {
        deleteAUserPreparedStatement.setString(1, name);
        deleteAUserPreparedStatement.execute();

    }

    public void deleteUsers() throws SQLException {
        deleteAllUsersPreparedStatement.execute();
    }

/*
* todo:
*   - create a Jdbc_greeting contructor
*       * load the driver => Class.forName()
*       *connect sql string insertPrep => conn.preparestatement(INSERT_USER_SQL)
*   - create sql string for queries => INSERT_USER_SQL = "INSERT..."
*   - create methods:
*       - addUser
*       - updateUser
*       - deleteUser/deleteUsers
*       -findUser/findUsers
* */
}
