package deepo.com.deepoECommerce.dataAccess.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchSuggestionKeywordInfo {

    String keyword;

    StringBuilder link;

    Integer rank;
}
