package steps;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.RequestModel.OrderRequest;
import model.RequestModel.PetRequest;
import model.RequestModel.UserRequest;
import model.ResponseModel.*;


import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    @Step("Getting an pet")
    public PetResponse getPetById(int Id, int statusCode){

        return given()
                .when()
                .get("pet/"+Id)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(PetResponse.class);
    }

    @Step("Getting a list of pets")
    public List<PetResponse> findByStatus(String status, int statusCode) {

        return given()
                .when()
                .get("pet/findByStatus?status="+status)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().jsonPath().getList("data", PetResponse.class);
    }

    @Step("Getting an order")
    public OrderResponse getOrderById(int id, int statusCode) {
        return given()
                .when()
                .get("store/order/"+id)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(OrderResponse.class);
    }

    @Step("Getting a pet's inventory")
    public void getInventoryByStatus() {
         given()
                 .when()
                .get("store/inventory")
                .then()
                .assertThat()
                .statusCode(200).extract().response();
    }




    @Step("Getting a user")
    public UserResponse getUserByUsername(String username, int statusCode){
        return given()
                .when()
                .get("user/"+username)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(UserResponse.class);
    }

    @Step("Log in to account")
    public ApiResponse getUserByLogin(String username, String password, int statusCode){
        return given()
                .when()
                .get("user/login/?username="+ username + "&password=" + password)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(ApiResponse.class);
    }

    @Step("Log out of account")
    public ApiResponse getUserLogout(int statusCode){
        return given()
                .when()
                .get("user/logout")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(ApiResponse.class);
    }

    @Step("Adding a pet")
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

    @Step("Pet Upgrade")
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

    @Step("Deleting a pet")
    public ApiResponse deletesPet (int id, int statusCode) {
        return given()
                .when()
                .delete("pet/"+id)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(ApiResponse.class);
    }

    @Step("Adding an order")
    public OrderResponse postOrderForPet (OrderRequest orderRequest, int statusCode) {
        return given()
                .when()
                .body(orderRequest)
                .contentType(ContentType.JSON)
                .post("store/order")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(OrderResponse.class);
    }

    @Step("Deleting an order")
    public ApiResponse deletesOrderById (int orderId, int statusCode) {
        return given()
                .when()
                .delete("store/order/"+orderId)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(ApiResponse.class);
    }

    @Step("Adding a list of users")
    public ApiResponse postListUsers (List<UserRequest> users, int statusCode) {
        return given()
                .when()
                .body(users)
                .contentType(ContentType.JSON)
                .post("user/createWithArray")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().as(ApiResponse.class);
    }

    @Step("User Update")
    public ApiResponse putUser (String username, UserRequest userRequest, int statusCode) {
        return given()
                .when()
                .body(userRequest)
                .contentType(ContentType.JSON)
                .put("user/"+username)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().as(ApiResponse.class);
    }

    @Step("Adding a user")
    public ApiResponse postNewUser (UserRequest userRequest, int statusCode){
        return given()
                .when()
                .body(userRequest)
                .contentType(ContentType.JSON)
                .post("user")
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(ApiResponse.class);
    }

    @Step("Deleting a user")
    public ApiResponse deletesUser (String username, int statusCode) {
        return given()
                .when()
                .delete("user/"+username)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response().body().as(ApiResponse.class);
    }



}
