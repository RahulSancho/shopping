package com.project.shopping.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.shopping.model.Products;
import com.project.shopping.repo.ProductsRepository;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository products;

    public void create(String  productName,int productPrice,int categoryId,MultipartFile photos) {
        Products pro = new Products();
        String fileName = StringUtils.cleanPath(photos.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("Not a valid file");
        }
        try{
            pro.setPhotos(Base64.getEncoder().encodeToString(photos.getBytes()));
        }catch(Exception e){e.printStackTrace();}
        pro.setProductName(productName);
        pro.setProductPrice(productPrice);
        pro.setCategoryId(categoryId);
        products.save(pro);
    }

    public List<Products> find() {
        return products.findAll();
    }

    public Optional<Products> findOne(int productId) {
        return products.findById(productId);
    }

    public List<Products> retriveName(String ProductName) {
        return products.findByName(ProductName);
    }

    public void erase(int id) {
        products.deleteById(id);
    }

    public Products updateById (int id, Products prod){
        Optional<Products> productId=products.findById(id);
        if(productId.isPresent()){
            Products productUpdate=productId.get();
            productUpdate.setProductName(prod.getProductName());
            productUpdate.setProductPrice(prod.getProductPrice());
            productUpdate.setCategoryId(prod.getCategoryId());
            return(products.save(productUpdate));

        }
        else{
            return null;
        }
    }



}
