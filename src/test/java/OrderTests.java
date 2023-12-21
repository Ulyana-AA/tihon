import io.qameta.allure.*;
import model.RequestModel.*;
import org.testng.annotations.Test;

@Epic("OrderTests")

public class OrderTests extends BaseTest {

    @Story("Getting an order")
    @Test(description = "Getting an order")
    public void getOrderById() {
        API_STEPS.getOrderById(2, 200);
    }

    @Story("Adding an order")
    @Test(description = "Adding an order")
    public void postOrderForPet() {
        OrderRequest orderRequest = new OrderRequest(5L, 0, 0, "2023-12-20T10:51:24.023Z", "placed", true);
        API_STEPS.postOrderForPet(orderRequest, 200);
    }

    @Story("Deleting an order")
    @Test(description = "Deleting an order")
    public void deletesOrderById() {
        API_STEPS.deletesOrderById(3, 404);
    }

}
