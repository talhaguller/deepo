    package deepo.com.deepoECommerce.business.concretes;

    import deepo.com.deepoECommerce.business.abstracts.ProductService;
    import deepo.com.deepoECommerce.dataAccess.abstracts.ProductRepository;
    import deepo.com.deepoECommerce.entities.concretes.Product;
    import lombok.AllArgsConstructor;
    import lombok.NoArgsConstructor;
    import org.json.JSONException;
    import org.json.JSONObject;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.List;
    import java.util.Optional;


    @Service
    @NoArgsConstructor
    @AllArgsConstructor

    public class ProductManager implements ProductService {

        @Autowired
        private ProductRepository productRepository;


        @Override
        public List<Product> findAllProduct() {
            return productRepository.findAll();
        }

        @Override
        public Optional<Product> findById(int id) {
            return productRepository.findById(id);
        }




        @Override
        public Product updateProduct(Product product) {
            Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
            assert existingProduct != null;
            existingProduct.setProduct_title(product.getProduct_title());
            existingProduct.setApp_sale_price_currency(product.getApp_sale_price_currency());
            existingProduct.setEvaluate_rate(product.getEvaluate_rate());
            existingProduct.setOriginal_price(product.getOriginal_price());
            existingProduct.setProduct_detail_url(product.getProduct_detail_url());
            existingProduct.setProductId(product.getProductId());
            existingProduct.setApp_sale_price(product.getApp_sale_price());
            existingProduct.setProduct_main_image_url(product.getProduct_main_image_url());
            return productRepository.save(existingProduct);
        }

        @Override

        public void addProduct(Product Product) throws IOException, InterruptedException, JSONException {


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://aliexpress-datahub.p.rapidapi.com/item_detail_2?itemId=3256804591426248"))
                    .header("X-RapidAPI-Key", "56da66ad1bmshd8181593cb546adp170170jsn9348eb16959f")
                    .header("X-RapidAPI-Host", "aliexpress-datahub.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            File file = new File("dosya.json");
            if (!file.exists()) { file.createNewFile();
            } FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(response.body()); bWriter.close();

            JSONObject myResponse = new JSONObject(response.body());




            Product product = new Product();
            product.setProduct_title(String.valueOf(myResponse.getString("product_title")));
            product.setProduct_main_image_url(String.valueOf(myResponse.getString("product_main_image_url")));
            product.setApp_sale_price(String.valueOf(myResponse.getString("app_sale_price")));
            product.setApp_sale_price_currency(String.valueOf(myResponse.getString("app_sale_price_currency")));
            product.setProduct_detail_url(String.valueOf(myResponse.getString("product_detail_url")));
            product.setEvaluate_rate(String.valueOf(myResponse.getString("product_id")));
            product.setOriginal_price(String.valueOf(myResponse.getString("evaluate_rate")));
            product.setOriginal_price(String.valueOf(myResponse.getString("original_price")));


            this.productRepository.save(product);;
        }


    }