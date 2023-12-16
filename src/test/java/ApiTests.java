import model.RequestModel.PetRequest;
import model.RequestModel.TagRequest;
import model.ResponseModel.Category;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ApiTests extends BaseTest {

    @Test(description = "Получение питомца")
    public void getPetById() {
        API_STEPS.getPetById(1, 200);
    }


    @Test(description = "Получение списка питомцев по статусу")
    public void getPetsByStatus(){
        API_STEPS.findByStatus("pending", 200);
    }

    @Test(description = "Получение заказа")
    public void getOrderById(){
        API_STEPS.getOrderById(2, 200);
    }

    @Test(description = "Получение инвентаря питомца")
    public void getInventoryByStatus(){
        API_STEPS.getInventoryByStatus(200);
    }

    @Test(description = "Получение пользователя по username")
    public void getUserByUsername(){
        API_STEPS.getUserByUsername("string", 200);
    }

    @Test(description = "Получение пользователя по username и password")
    public void getUserByLoin(){
        API_STEPS.getUserByLogin("string", "string", 200);
    }

    @Test(description = "Выход из аккаунта")
    public void getUserLogout(){
        API_STEPS.getUserLogout(200);
    }

    @Test(description = "Добавление нового питомца в магазин")
    public void postNewPetToStore(){
        Category category = new Category(777, "people");
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        List<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(777, "string"));

        PetRequest petRequest = new PetRequest(777, category, "name", photoUrls, tags, "available");
        API_STEPS.postNewPetToStore(petRequest, 200);
    }
    @Test(description = "Обновление существующего питомца")
    public void putExistingPet(){
        Category category = new Category(777, "Dogs");
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        List<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(777, "string"));

        PetRequest petRequest = new PetRequest(777, category, "name", photoUrls, tags, "available");
        API_STEPS.putExistingPet(petRequest, 200);
    }



}
