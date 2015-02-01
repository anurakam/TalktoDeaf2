package project.talktodeaf.Rest;

import project.talktodeaf.Model.Example;
import retrofit.http.GET;

/**
 * Created by wiwat on 1/31/2015.
 */
public interface ApiService {


    @GET("/Restful/index.php")
    Example getExample();

}