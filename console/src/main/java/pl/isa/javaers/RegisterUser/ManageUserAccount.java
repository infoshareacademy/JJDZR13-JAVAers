package pl.isa.javaers.RegisterUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManageUserAccount {

    public static void crateFileWithPassword(String login, String password) {
        if (!isUserExist(login)) {
            try {
                FileWriter myWriter = new FileWriter(login);
                myWriter.write(password);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isUserExist (String login) {
        return readFile(login).exists();
    }

    public static void changePassword(String login, String password) {
        if (isUserExist(login)) {
            readFile(login).delete();
        }
        crateFileWithPassword(login, password);
    }

    private static File readFile(String login){
        return new File(login);
    }
}
