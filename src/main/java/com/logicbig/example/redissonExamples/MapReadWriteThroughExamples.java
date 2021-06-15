package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.MapOptions;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.api.map.MapLoader;
import org.redisson.api.map.MapWriter;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MapReadWriteThroughExamples {
/*

    public static void main(String[] args) throws IOException, SQLException {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "admin", "admin");

        MapWriter<String, String> mapWriter = new MapWriter<String, String>() {


            @Override
            public void write(String key, String value) {

            }

            @Override
            public void writeAll(Map<String, String> map) {

            }

            @Override
            public void delete(String key) {

            }

            @Override
            public void deleteAll(Collection<String> keys) {

            }

            @Override
            public void write(Map<String, String> map) {
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student (id, name) values (?, ?)");
                    try {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            preparedStatement.setString(1, entry.getKey());
                            preparedStatement.setString(2, entry.getValue());
                            preparedStatement.addBatch();
                        }
                        preparedStatement.executeBatch();
                    } finally {
                        preparedStatement.close();
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }

            @Override
            public void delete(Collection<String> keys) {
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM student where id = ?");
                    try {
                        for (String key : keys) {
                            preparedStatement.setString(1, key);
                            preparedStatement.addBatch();
                        }
                        preparedStatement.executeBatch();
                    } finally {
                        preparedStatement.close();
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }

            }
        };

        MapLoader<String, String> mapLoader = new MapLoader<String, String>() {

            @Override
            public Iterable<String> loadAllKeys() {
                List<String> list = new ArrayList<String>();
                try {
                    Statement statement = conn.createStatement();
                    try {
                        ResultSet result = statement.executeQuery("SELECT id FROM student");
                        while (result.next()) {
                            list.add(result.getString(1));
                        }
                    } finally {
                        statement.close();
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }

                return list;
            }

            @Override
            public String load(String key) {
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement("SELECT name FROM student where id = ?");
                    try {
                        preparedStatement.setString(1, key);
                        ResultSet result = preparedStatement.executeQuery();
                        if (result.next()) {
                            return result.getString(1);
                        }
                        return null;
                    } finally {
                        preparedStatement.close();
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        MapOptions<String, String> options =
                MapOptions.<String, String>defaults()
                        .writer(mapWriter)
                        .loader(mapLoader);

        RMap<String, String> map = redisson.getMap("myMap", options);
        map.put("1", "Willy");
        map.put("2", "Andrea");
        map.put("3", "Bob");

        String name1 = map.get("1");
        String name2 = map.get("2");
        String name3 = map.get("3");

        redisson.shutdown();
    }*/

}
