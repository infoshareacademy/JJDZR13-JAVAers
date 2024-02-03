package pl.isa.javaers.RegisterUser;

import java.io.File;

public class PasswordEdit {

    CreateUserAccount createUserAccount = new CreateUserAccount();

    public CreateUserAccount changePassword(String login, String password) {
        if (createUserAccount.isUserExist(login)) {
            File read = new File(login);
            read.delete();
        }
        return createUserAccount.crateFileWithPassword(login, password);
    }
}
