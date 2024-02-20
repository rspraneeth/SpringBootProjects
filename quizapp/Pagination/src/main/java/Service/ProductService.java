package Service;

import model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts(int offset, int pageSize){

        repo.findFirstNProducts(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, "price")));

    }
}
