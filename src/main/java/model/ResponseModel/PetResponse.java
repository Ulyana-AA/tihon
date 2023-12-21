package model.ResponseModel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PetResponse {
    public int id;
    @JsonProperty("category")
    public CategoryResponse category;
    @JsonProperty("name")
    public String name;
    @JsonProperty("photoUrls")
    public List<String> photoUrls;
    @JsonProperty("tags")
    public List<Tag> tags;
    @JsonProperty("status")
    public String status;
}
