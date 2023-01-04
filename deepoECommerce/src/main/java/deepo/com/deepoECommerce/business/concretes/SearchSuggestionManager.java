package deepo.com.deepoECommerce.business.concretes;

import deepo.com.deepoECommerce.business.abstracts.SearchSuggestionService;
import deepo.com.deepoECommerce.dataAccess.concretes.SearchSuggestionKeywordInfo;
import deepo.com.deepoECommerce.util.Permutation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class SearchSuggestionManager implements SearchSuggestionService {

    HashMap<String,List<SearchSuggestionKeywordInfo>> prefixKeywordsMap = new HashMap<>();

    List<SearchSuggestionKeywordInfo> defaultSearchSuggestionList = new LinkedList<>();

    private JSONObject parseJSONObject(String json) throws JSONException{
        return new JSONObject(json);
    }

    private JSONArray parseJSONArray(JSONObject jsonObject,String key) throws  JSONException{
        return jsonObject.getJSONArray(key);
    }

    private void addJsonObjKeywordToMap(JSONObject jsonResponse, String key, String attributeName) throws JSONException{

        JSONArray jsonArray = parseJSONArray(jsonResponse,key);

        for (int index =0; index < jsonArray.length(); ++index){
            JSONObject jsonObject = new JSONObject(jsonArray.get(index).toString());
            StringBuilder filterLink = new StringBuilder();
            addSearchSuggestionKeywords(jsonObject.getString("type"),
                    filterLink.append(attributeName).append("=").append(jsonObject.getString("id")));

            if (index <10 && attributeName.equals("apparels")){
                defaultSearchSuggestionList.add(new SearchSuggestionKeywordInfo(jsonObject.getString("type"),
                        filterLink,1));
            }
        }
    }

    //anahtar kelimeyi ekliyor
    private void addKeywordsToMap(JSONObject jsonResponse, String key) throws JSONException {
        JSONArray jsonArray = parseJSONArray(jsonResponse,key);

        for (int index=0; index<jsonArray.length(); ++index){
            StringBuilder filterLink = new StringBuilder();
            addSearchSuggestionKeywords(jsonArray.get(index).toString(),
                    filterLink.append("productname=").append(jsonArray.get(index).toString()));

        }
    }

     private void constructAndAddKeywordCombination(JSONObject jsonResponse, String key, String[] attributeNames) throws JSONException{
        JSONArray jsonArray = parseJSONArray(jsonResponse,key);

        for (int index=0; index < jsonArray.length(); ++index){
            JSONObject jsonObject = new JSONObject(jsonArray.get(index).toString());
            int noOfAttributes = attributeNames.length;
            String[] keywords= new String[noOfAttributes];
            StringBuilder filterLink = new StringBuilder();
            for (int attrIndex=1; attrIndex <= noOfAttributes; ++attrIndex){
                keywords[attrIndex-1]=jsonObject.getString(String.format("attr%d_type", attrIndex));
                filterLink.append(attributeNames[attrIndex-1]).append("=")
                        .append(jsonObject.getString(String.format("attr%d_id",attrIndex))).append("::");
            }

            if (filterLink.charAt(filterLink.length() - 1) == ':'){
                filterLink.setLength(filterLink.length()-2);
            }

            Permutation permutation = new Permutation(keywords);
            for (String keyword : permutation.getOutput()) {
                addSearchSuggestionKeywords(keyword,filterLink);
            }
        }
    }



    private void addSearchSuggestionKeywords(String keyword, StringBuilder link){
        for (int index=0; index < keyword.length(); ++index) {
            String prefix = keyword.substring(0,index+1).toLowerCase();
            if (!prefixKeywordsMap.containsKey(prefix)) {
                prefixKeywordsMap.put(prefix, new ArrayList<>(List.of(
                        new SearchSuggestionKeywordInfo(keyword, link, 1))));
            }else{
                List<SearchSuggestionKeywordInfo> keywordList = prefixKeywordsMap.get(prefix);
                keywordList.add(new SearchSuggestionKeywordInfo(keyword,link,1));
            }
        }
    }

    @Override
    public void loadSearchSuggestionToMap() {

    }

    @Override
    public List<SearchSuggestionKeywordInfo> searchKeywordFromMap(String q) {
        return null;
    }

    @Override
    public List<SearchSuggestionKeywordInfo> getDefaultSearchSuggestions() {
        return null;
    }
}
