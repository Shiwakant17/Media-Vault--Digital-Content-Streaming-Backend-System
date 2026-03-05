package repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.UserList;
import model.Song;
import model.User;

public class UserRepository {
    UserList userList = new UserList();

    public void addUser(User user) throws IOException {
        File usersFile = new File(
                "D:/Projects/Core JAVA/Media Vault - Digital Content & Streaming Backend System/Program/src/data/Users.csv");
        if (!usersFile.exists()) {
            usersFile.createNewFile();
        }

        BufferedOutputStream bufferedOutputStreamUsers = new BufferedOutputStream(
                new FileOutputStream(usersFile, true));

        String userId = user.getUserId();
        String userName = user.getName();
        long userPhone = user.getPhone();
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();
        ArrayList playedSongs = user.getPlayedSongs();

        String userData = userId + "," + userName + "," + userPhone + "," + userEmail + "," + userPassword + ","
                + " song history: " + playedSongs + "\n";
        bufferedOutputStreamUsers.write(userData.getBytes());
        bufferedOutputStreamUsers.close();
    }

    public void addSongToHistory(ArrayList<Song> list, String email) throws FileNotFoundException {
         File userFile = new File(
                "D:/Projects/Core JAVA/Media Vault - Digital Content & Streaming Backend System/Program/src/data/Users.csv");

        BufferedInputStream bufferedInputStreamSongs = new BufferedInputStream(new FileInputStream(userFile));

        Scanner scanUsers = new Scanner(bufferedInputStreamSongs);

        while (scanUsers.hasNextLine()) {
            String user1 = scanUsers.nextLine();
            String user1DetailArray[] = user1.split(",");

            if (scanUsers.hasNextLine()) {
                String user = scanUsers.nextLine();
                String[] userDetailArray = user.split(",");

                

            }

        }
    }
}
