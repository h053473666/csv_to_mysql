package com.alien.service;

import com.alien.dao.ProductMapper;
import com.alien.pojo.Product;
import com.alien.utils.MyBatisUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.ibatis.session.SqlSession;

import java.io.FileReader;
import java.io.IOException;


public class ProductService {

    public static void main(String[] args) throws IOException, CsvValidationException {

        String filePath = "src/main/resources/csv/product.csv";
        String[] row; //字串array
        Product product = new Product();
        int num = 0;
        // 讀取csv
        FileReader fileReader = new FileReader(filePath);
        CSVReader openCSVReader = new CSVReader(fileReader);

        // 獲得字串array
        // 第一個 row是col
        row = openCSVReader.readNext();

        //
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        while((row = openCSVReader.readNext()) != null){
            product.setFromRow(row);
            productMapper.insertProduct(product);

            num += 1;
            if (num == 100) {
                sqlSession.commit();
                num = 0;
            }
        }

        sqlSession.commit();
        sqlSession.close();
    }


}
