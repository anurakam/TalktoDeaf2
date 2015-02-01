package project.talktodeaf.Rest;

import java.util.List;

import project.talktodeaf.Model.Book;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by wiwat on 2/1/2015.
 */
public interface ApiService {

    @GET("/Restful/book.php")
    void getBookByMethodWithCallback(Callback<List<Book>> callback);

}
