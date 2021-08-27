package ci;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ci.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thomas
 */
public class DataMapper {

    public static ArrayList<String> seeAllNames(){
          ArrayList<String> names = new ArrayList();
        try {
            Connection con = DBconnector.connection();
            String SQL = "SELECT * FROM startcode.usertable";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("fname");
                names.add(name);
                System.out.println(name);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return names;
    }

    public static void main(String[] args) {
        seeAllNames();
    }

    public static User seeUserOnUserId(int id) {

        try {
            Connection con = DBconnector.connection();
            String SQL = "SELECT * FROM startcode.usertable where id=?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id1 = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String pw = rs.getString("pw");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                User user = new User(id, fname, lname, pw, phone, address);
                return user;
            }else{
                System.out.println("Hej hej");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static int updateUserbyUserId(String phone,int user_id) {
        try {
            Connection con = DBconnector.connection();
            String SQL = "UPDATE startcode.usertable SET phone=? WHERE id=?;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1,phone);
            ps.setInt(2,user_id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}