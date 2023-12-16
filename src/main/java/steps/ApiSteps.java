package steps;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.RequestModel.PetRequest;
import model.ResponseModel.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiSteps {



    @Step("Получить пользователя по ID")
    public PetResponse getPetById(int Id, int statusCode){

        return given()
                .when()
                .get("pet/"+Id)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(PetResponse.class);
    }

    @Step("Найти список питомцев по статусу")
    public List<PetResponse> findByStatus(String status, int statusCode) {

        return given()
                .when()
                .get("pet/findByStatus?status=pending")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().jsonPath().getList("data", PetResponse.class);
    }

    @Step("Получить заказ по ID")
    public OrderResponse getOrderById(int id, int statusCode) {
        return given()
                .when()
                .get("store/order/"+id)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(OrderResponse.class);
    }

    @Step("Получить инвентарь питомцев по статусу")
    public InventoryResponse getInventoryByStatus(int statusCode) {
        return given()
                .when()
                .get("store/inventory")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(InventoryResponse.class);
    }



    @Step("Получить пользователя по username")
    public UserResponse getUserByUsername(String username, int statusCode){
        return given()
                .when()
                .get("user/"+username)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(UserResponse.class);
    }

    @Step("Войти в аккаунт")
    public UserLoginResponse getUserByLogin(String username, String password, int statusCode){
        return given()
                .when()
                .get("user/login/?username="+ username + "&password=" + password)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(UserLoginResponse.class);
    }

    @Step("Выйти из аккаунта")
    public UserLoginResponse getUserLogout(int statusCode){
        return given()
                .when()
                .get("user/logout")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(UserLoginResponse.class);
    }

    @Step("Добавить нового питомца в магазин")
    public PetResponse postNewPetToStore (PetRequest petRequest, int statusCode){
        return given()
                .when()
                .body(petRequest)
                .contentType(ContentType.JSON)
                .post("pet")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(PetResponse.class);
    }

    @Step("Обновить существующего питомца")
    public PetResponse putExistingPet (PetRequest petRequest, int statusCode){
        return given()
                .when()
                .body(petRequest)
                .contentType(ContentType.JSON)
                .put("pet")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(PetResponse.class);
    }

    @Step("Обновить питомца с определенными данными")
}
