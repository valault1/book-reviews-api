package ault.BookReviews.models.Requests;

import java.util.List;

import org.json.simple.JSONObject;

import lombok.Data;

@Data
public class CreateEntityRequest {

  private String entityTypeId;

  private String name;

  private JSONObject entityProperties;

  private List<String> tags;

}
