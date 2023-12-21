import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import model.RequestModel.*;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

@Epic("UserTests")

public class UserTests extends BaseTest {

    @Story("Log in to account")
    @Test(description = "Log in to account")
    public void getUserByLogin() {
        API_STEPS.getUserByLogin("string", "string", 200);
    }

    @Story("Log out of account")
    @Test(description = "Log out of account")
    public void getUserLogout() {
        API_STEPS.getUserLogout(200);
    }

    @Story("Adding a list of users")
    @Test(description = "Adding a list of users")
    public void postListUsers() {
        List<UserRequest> users = new ArrayList<>();
        users.add(new UserRequest(5L, "user1", "ivan", "ivanov", "ivan@gmail.com", "12345", "544", 1));
        users.add(new UserRequest(5L, "user2", "kirill", "ivanov", "kril@mail.com", "12345", "224", 1));
        API_STEPS.postListUsers(users, 200);
    }

    @Story("User Update")
    @Test(description = "User Update")
    public void putUser(){
        UserRequest userRequest = new UserRequest(5L, "ulyana-aa", "ulyana", "andreeva", "string@gmail.com", "12345", "89092556521", 10);
        API_STEPS.putUser("ulyana-aa", userRequest, 200);
    }

    @Story("Adding a user")
    @Test(description = "Adding a user")
    public void postNewUser() {
        UserRequest userRequest = new UserRequest(3L, "string1", "tixa", "homyshen", "taxi@gmail.com", "12345", "89092556521", 3);
        API_STEPS.postNewUser(userRequest, 200);
    }

    @Story("Getting a user")
    @Test(description = "Getting a user")
    public void getUserByUsername() {
        API_STEPS.getUserByUsername("string", 200);
    }

    @Story("Deleting a user")
    @Test(description = "Deleting a user")
    public void deletesUser() {
        API_STEPS.deletesUser("string", 200);
    }
}
