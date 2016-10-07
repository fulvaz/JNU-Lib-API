package router.fulvaz;

import com.google.gson.Gson;
import config.fulvaz.Config;
import model.fulvaz.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import spark.Request;
import spark.Response;
import spark.Route;
import util.fulvaz.Http;

import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by fulvaz on 16/10/6.
 */


// name: td.briefcitDetail > span.briefcitTitle > a
// bookDetail: td.briefcitDetail childNode 6
// url: td.briefcitDetail > span.briefcitTitle > a
// cover:  img[alt=书封]
public class Search implements Route{
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String bookName = request.params(":name");
        String requestURL = Config.searchBaseURL + bookName;

        Document doc = Jsoup.connect(requestURL).get();


        ArrayList<Result> results = new ArrayList<Result>();
        for (Element row: doc.select(".briefCitRow")) {
            String name = row.select("span.briefcitTitle > a").text();
            String bookDetail = row.select("td.briefcitDetail").get(0).childNode(6).toString();
            String url = Config.siteURL + row.select("td.briefcitDetail > span.briefcitTitle > a").attr("href");
            String cover = row.select("img[alt=书封]").attr("src");
            results.add(new Result(name, bookDetail, url, cover));
        }




        Gson gson = new Gson();

        return gson.toJson(results);
    }
}
