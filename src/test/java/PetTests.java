import io.qameta.allure.*;
import model.RequestModel.*;
import model.ResponseModel.*;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

@Epic("PetTests")

public class PetTests extends BaseTest {

    @Story("Getting an pet")
    @Test(description = "Getting an pet")
    public void getPetById() {
        API_STEPS.getPetById(3, 200);
    }

    @Story("Getting a list of pets")
    @Test(description = "Getting a list of pets")
    public void getPetsByStatus() {
        API_STEPS.findByStatus("pending", 200); }

    @Story("Getting a pet's inventory")
    @Test(description = "Getting a pet's inventory")
    public void getInventoryByStatus() { API_STEPS.getInventoryByStatus();}

    @Story("Adding a pet")
    @Test(description = "Adding a pet")
    public void postNewPetToStore() {
        CategoryResponse category = new CategoryResponse(777, "people");
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        List<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(777, "string"));

        PetRequest petRequest = new PetRequest(777, category, "name", photoUrls, tags, "available");
        API_STEPS.postNewPetToStore(petRequest, 200);
    }

    @Story("Pet Upgrade")
    @Test(description = "Pet Upgrade")
    public void putExistingPet() {
        CategoryResponse category = new CategoryResponse(777, "Dogs");
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        List<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(777, "string"));

        PetRequest petRequest = new PetRequest(777, category, "name", photoUrls, tags, "available");
        API_STEPS.putExistingPet(petRequest, 200);
    }

    @Story("Deleting a pet")
    @Test(description = "Deleting a pet")
    public void deletesPet() {
        API_STEPS.deletesPet(3, 200);
    }
}
