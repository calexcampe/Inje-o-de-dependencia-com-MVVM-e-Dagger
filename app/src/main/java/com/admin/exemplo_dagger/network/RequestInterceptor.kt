
import android.content.SharedPreferences
import androidx.annotation.NonNull
import com.admin.exemplo_dagger.ExemploDaggerApplication
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 * Este interceptador okhttp é responsável por adicionar os parâmetros e cabeçalhos de consulta comuns
 * para todas as chamadas de serviço
 * */
class RequestInterceptor : Interceptor {
    lateinit var sharedPref: SharedPreferences

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        sharedPref = ExemploDaggerApplication.appContext!!.getSharedPreferences("App", 0)
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()

        val url = originalHttpUrl.newBuilder()
                .build()

        val request = originalRequest.newBuilder().url(url).addHeader("Authorization","Bearer "+sharedPref.getString("token","")!!).build()
        return chain.proceed(request)
    }
}