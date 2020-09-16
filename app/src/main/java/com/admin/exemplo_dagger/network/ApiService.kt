package com.admin.exemplo_dagger.network

import com.admin.exemplo_dagger.response.SolicitationsResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*
/**

 */
/*
* A interface APIService, que conterá a semântica de todas as chamadas REST.
* */
interface ApiService {

    @GET("solicitations")
    fun getSolicitations(
        @Query("status") status : String,
        @Query("nextServicesDays") includeUsers : Int
    ) : Observable<SolicitationsResponse>

}