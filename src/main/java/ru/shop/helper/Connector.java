package ru.shop.helper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public  class Connector {
    private static Connection conn = null;
    private Connector(){}
    //Синхронизация?
    public static synchronized Connection getConn() throws IOException {
          Properties data = new Properties();
          try  {
              if  (conn == null) {
                  try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))) {
                      data.load(in);
                      String url = data.getProperty("url");
                      String username = data.getProperty("username");
                      String password = data.getProperty("password");
                      try {
                          conn = DriverManager.getConnection(url, username, password);
                          Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                          System.out.println("Connection IS OK");
                          return conn;
                      } catch (Exception e) {
                          e.getStackTrace();
                          System.out.println("Connection failed...");
                      }
                  }
              }
              return conn;
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      }
}