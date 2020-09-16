package com.admin.exemplo_dagger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.admin.exemplo_dagger.network.ApiService
import com.admin.exemplo_dagger.response.SolicitationsResponse
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

/**

 **/

class HistoryPayServicesViewModel @Inject constructor(val apiService: ApiService) : ViewModel(){

    lateinit var solicitations: MutableLiveData<SolicitationsResponse>
    val errorMessageString: MutableLiveData<String> = MutableLiveData()

    // Variável de acumulo de inscrições.
    private lateinit var subscription: Disposable
    // Método de remoção de inscrições do RXJava, mediante ao fim do ciclo de vida do viewModel.
    override fun onCleared() {
        super.onCleared()
        try {
            subscription.dispose()
        } catch (exception : Exception){
            exception.message
        }
    }

    fun getSolicitations(idUser:Int, status: String) : MutableLiveData<SolicitationsResponse>{
        solicitations = MutableLiveData()
        subscription =
            apiService.getSolicitations(status,1000)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({r -> solicitations.value = r },
                    {
                        try {
                            onRetrieveError(it.localizedMessage)
                        } catch (exception: Exception) {
                            errorMessageString.value = "Erro desconhecido, tente novamente mais tarde!"
                        }
                    })

        return solicitations
    }

    private fun onRetrieveError(localizedMessage: String?) {

    }


}