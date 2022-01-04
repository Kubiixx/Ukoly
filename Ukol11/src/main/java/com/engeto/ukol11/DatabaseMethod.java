package com.engeto.ukol11;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMethod  implements  GoodsMethods{

    public void loadAllDB () {
        System.out.println("*******************\nNačtení celé DB ");
        List <Item> itemList = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ukol11", "root", "12345")){
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM items";
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                Item item = new Item();
                item.setItemFromDatabase(resultSet);
                itemList.add(item);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        itemList.forEach(i -> System.out.println(i.getName()));
    }

    public Item loadItemById (Integer id){
        System.out.println("*******************\nNačtení Itemu dle jeho ID: " +id);
        Item item = new Item();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ukol11", "root", "12345")){
            String preparedStatementString = "SELECT * FROM items WHERE id =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementString);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            item.setItemFromDatabase(resultSet);
            item.printItem();

        } catch (Exception e){
            e.printStackTrace();
        }
        return item;

    }

    public void deleteAllOutOfStockItems(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ukol11", "root", "12345")){
            String preparedStatementString = "DELETE FROM items WHERE numberInStock =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementString);
            preparedStatement.setInt(1, 0);
            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Item> loadAllAvailableItems(){
        System.out.println("********************\n Pouze dostupné itemy:");
        List <Item> itemList = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ukol11", "root", "12345")){
            String preparedStatementString = "SELECT * FROM items WHERE numberInStock !=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementString);
            preparedStatement.setInt(1, 0);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setItemFromDatabase(resultSet);
                itemList.add(item);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        itemList.forEach(i -> System.out.println(i.getName()+" ; Počet dostupných kusů: " +i.getNumberInStock()));
        return itemList;
    }

    public void saveItem(Item item){
        System.out.println("*******************\nUložení nového itemu" +item.getName());
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ukol11", "root", "12345")){
            String preparedStatementString = "INSERT INTO items VALUES (?, ?, ?, ?, ?, ?, ?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementString);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getPartNo());
            preparedStatement.setString(3, item.getSerialNo());
            preparedStatement.setString(4, item.getName());
            preparedStatement.setString(5, item.getDescription());
            preparedStatement.setInt(6, item.getNumberInStock());
            preparedStatement.setBigDecimal(7, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updatePrice(Integer id, BigDecimal newPrice){
        System.out.println("*******************\nAktualizace ceny u itemu s ID: " +id+ "na cenu: " +newPrice);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ukol11", "root", "12345")){
            String preparedStatementString = "UPDATE items SET price = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementString);
            preparedStatement.setBigDecimal(1, newPrice);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
