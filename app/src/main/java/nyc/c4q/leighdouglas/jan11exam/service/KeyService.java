package nyc.c4q.leighdouglas.jan11exam.service;

import nyc.c4q.leighdouglas.jan11exam.model.KeyList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by leighdouglas on 1/11/17.
 */

public interface KeyService {

    static String BASE_URL = "http://jsjrobotics.nyc/";

    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<KeyList> getListOfKeys();
}
