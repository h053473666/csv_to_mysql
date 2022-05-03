package com.alien.service;

import com.alien.dao.SimilarMapper;

import com.alien.pojo.Similar;
import com.alien.utils.MyBatisUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.ibatis.session.SqlSession;

import java.io.FileReader;
import java.io.IOException;

public class SimilarService {
    public static void main(String[] args) throws IOException, CsvValidationException {
        String filePath = "src/main/resources/csv/similar2.csv";
        String[] row; //字串array
        Similar similar = new Similar();
        int num = 0;
        // 讀取csv
        FileReader fileReader = new FileReader(filePath);
        CSVReader openCSVReader = new CSVReader(fileReader);

        // 獲得字串array
        // 第一個 row是col
        row = openCSVReader.readNext();

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        SimilarMapper similarMapper = sqlSession.getMapper(SimilarMapper.class);
        while((row = openCSVReader.readNext()) != null){
            similar.setFromRow(row);
            similarMapper.insertSimilar(similar);

            num += 1;
            if (num == 1000) {
                sqlSession.commit();
                num = 0;
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
