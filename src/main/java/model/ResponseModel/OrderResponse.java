package model.ResponseModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderResponse {
    public int id;
    public int petId;
    public int quantity;
    public String shipDate;
    public String status;
    public Boolean complete;
}
