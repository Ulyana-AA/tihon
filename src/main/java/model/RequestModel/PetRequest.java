package model.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.ResponseModel.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PetRequest {
    public int id;
    public CategoryResponse category;
    public String name;
    public List<String> photoUrls;
    public List<TagRequest> tags;
    public String status;
}
