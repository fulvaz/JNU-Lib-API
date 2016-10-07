package app.fulvaz;

import router.fulvaz.Book;
import router.fulvaz.Search;

import static spark.Spark.*;

/**
 * Created by fulvaz on 16/10/6.
 */
public class App {
    public static void main(String[] args) {
        get("/search/:name", new Search());

        get("/book/url", new Book());

        after((req, res) -> {
            res.header("Content-Type", "application/json; charset=UTF-8");
            res.header("Access-Control-Allow-Origin", "*");
        });
    }



}
