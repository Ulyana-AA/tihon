package model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderRequest {
    public Long id;
    public int petId;
    public int quantity;
    public String shipDate;
    public String status;
    public Boolean complete;
}
