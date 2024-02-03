package pl.isa.javaers.RegisterUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUserAccount {

    public CreateUserAccount crateFileWithPassword(String login, String password) {
        if (!isUserExist(login)) {
            try {
                FileWriter myWriter = new FileWriter(login);
                myWriter.write(password);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isUserExist(String login) {
        File read = new File(login);
        return read.exists();
    }
}
