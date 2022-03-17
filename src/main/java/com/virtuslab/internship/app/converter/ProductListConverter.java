package com.virtuslab.internship.app.converter;

import com.virtuslab.internship.app.product.Product;
import com.virtuslab.internship.app.product.ProductDb;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Component
@Converter
public class ProductListConverter implements AttributeConverter<List<Product>, String> {
    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(List<Product> productList) {
        String outString = "";
        for(Product p: productList){
            outString += p.name() + SPLIT_CHAR;
        }
        if(outString != ""){
            return outString;
        }
        return null;
    }

    @Override
    public List<Product> convertToEntityAttribute(String product) {
        ProductDb productDb = new ProductDb();
        List<Product> returnList = new ArrayList<>();
        if(product != null){
            List<String> stringList = Arrays.asList(product.split(SPLIT_CHAR));
            for (String i: stringList) {
                returnList.add(productDb.getProduct(i));
            }
        }
        return returnList;
    }
}
