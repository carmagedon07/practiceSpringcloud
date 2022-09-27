package academy.digitallab.storeproduct;

import academy.digitallab.storeproduct.entity.Category;
import academy.digitallab.storeproduct.entity.Product;
import academy.digitallab.storeproduct.repository.ProductRepository;
import academy.digitallab.storeproduct.servicie.ProductServicie;
import academy.digitallab.storeproduct.servicie.ProductServicieImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Date;
import java.util.Optional;

public class ProductServicieMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductServicie productServicie;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        productServicie= new ProductServicieImpl(productRepository);
        Product computer = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("12.5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);



    }
    @Test
    public void whenValidGetId_ThenReturnProduct(){
        Product found=productServicie.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productServicie.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }

}
