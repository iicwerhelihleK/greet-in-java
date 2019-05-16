package greetings;

import java.sql.*;
import java.util.HashMap;

public class Jdbc_greeting implements GreetedHash {

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

    final String KOANS_DATABASE_URL = "jdbc:h2:./target/jdbc_greeting";
//    CREATE/ ADD
    final String ADD_A_USER_SQL = "insert into greeting (name, counter) values (?, ?)";

//    READ/ FIND
    final String FIND_A_USER_SQL = "select * from greeting where name = ?";
    final String FIND_ALL_USERS_SQL = "select * from greeting";

//    UPDATE
    final String UPDATE_A_USER_SQL = "update greeting SET counter = counter + 1 where name = ?";

//    DELETE
    final String DELETE_A_USER_SQL = "delete from greeting where name = ?";
    final String DELETE_ALL_USERS_SQL = "delete from greeting";


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
            findAllUsersPreparedStatement = conn.prepareStatement(FIND_ALL_USERS_SQL);

            updateAUserPreparedStatement = conn.prepareStatement(UPDATE_A_USER_SQL);

            deleteAUserPreparedStatement = conn.prepareStatement(DELETE_A_USER_SQL);
            deleteAllUsersPreparedStatement = conn.prepareStatement(DELETE_ALL_USERS_SQL);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public String greetPerson(String name, String language) throws SQLException {
        if(name.equals("1")){
            updateAUserPreparedStatement.setString(1, name);
            updateAUserPreparedStatement.executeUpdate();


        }else{
            addAUserPreparedStatement.setString(1, name);
            addAUserPreparedStatement.setInt(2, 1 );
            addAUserPreparedStatement.execute();

        }
        return name;

    }


    public HashMap<String, Integer> greeted() throws SQLException {
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


    public int greetedCount() {
        return 0;
    }


    public int greetedUser(String name) throws SQLException {
        HashMap<String, Integer> userNames = new HashMap<String, Integer>();
        findAUserPreparedStatement.setString(1, name);
        ResultSet rs = findAUserPreparedStatement.executeQuery();
        int counter = 0;
        if (rs.next()) {
            counter = rs.getInt("counter");
            userNames.put(name, counter);
        }
        return counter;
    }


    public String clearUser(String name) throws SQLException {
        deleteAUserPreparedStatement.setString(1, name);
        deleteAUserPreparedStatement.execute();
        return null;
    }


    public String clearsAll() throws SQLException {
        deleteAllUsersPreparedStatement.execute();
        return null;
    }


    public String exit() {
        return null;
    }
}
