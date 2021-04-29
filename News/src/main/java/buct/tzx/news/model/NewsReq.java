package buct.tzx.news.model;

import java.util.List;

public class NewsReq {
    private int code;
    private String message;
    private List<NewsModel>result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NewsModel> getResult() {
        return result;
    }

    public void setResult(List<NewsModel> result) {
        this.result = result;
    }
}
