package model.fulvaz;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fulvaz on 16/10/7.
 * 使用题名和检索号的md5作为id, 有可能以后会存入数据库
 *
 * 快速实现, 只实现借阅信息部分
 */



public class Book {
    private String name;
    private String bookDetail;
    private String url;
    private String cover;

    private ArrayList borrowInfo = new ArrayList();

    public Book(String name, String bookDetail, String url, String cover) {
        this.name = name;
        this.bookDetail = bookDetail;
        this.url = url;
        this.cover = cover;
    }

    public class Borrow {
        private String location;
        private String index;
        private String status;

        public Borrow(String index, String status, String location) {
            this.index = index;
            this.status = status;
            this.location = location;
        }
    }
}
