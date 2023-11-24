package retrofit2

import retrofit2.converter.gson.GsonConverterFactory

fun retrofitBuild(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}