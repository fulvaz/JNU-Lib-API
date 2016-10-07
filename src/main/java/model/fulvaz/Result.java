package model.fulvaz;

/**
 * Created by fulvaz on 16/10/7.
 */

// name: td.briefcitDetail > span.briefcitTitle > a
// bookDetail: td.briefcitDetail childNode 6
// url: td.briefcitDetail > span.briefcitTitle > a
// cover:  img[alt=书封]

public class Result {
    private String name;
    private String bookDetail;
    private String url;
    private String cover;

    public Result(String name, String bookDetail, String url, String cover) {
        this.name = name;
        this.bookDetail = bookDetail;
        this.url = url;
        this.cover = cover;
    }
}
