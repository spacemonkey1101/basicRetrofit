package com.example.basicretrofit.rest;


import com.example.basicretrofit.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//endpoint definition
public interface ApiInterface {
    //Call<T> object such as Call<MovieResponse> is returned

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
/*So, using this route the retrofit will generate the following URL:
http://api.themoviedb.org/3/movie/top_rated?api_key=12345678910111213

Each endpoint specifies an annotation of the HTTP method (GET, POST, etc.) and the parameters of this method can also have special annotations (@Query, @Path, @Body etc.)

Take a look to other annotations:

@Path – variable substitution for the API endpoint. For example movie id will be swapped for{id} in the URL endpoint.

@Query – specifies the query key name with the value of the annotated parameter.

@Body – payload for the POST call

@Header – specifies the header with the value of the annotated parameter*/