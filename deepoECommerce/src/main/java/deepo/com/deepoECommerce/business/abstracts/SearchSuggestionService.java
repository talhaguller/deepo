package deepo.com.deepoECommerce.business.abstracts;

import deepo.com.deepoECommerce.dataAccess.concretes.SearchSuggestionKeywordInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchSuggestionService {

    void loadSearchSuggestionToMap();

    List<SearchSuggestionKeywordInfo> searchKeywordFromMap(String q);

    List<SearchSuggestionKeywordInfo> getDefaultSearchSuggestions();
}
