package retrofit2

import kotlinx.coroutines.runBlocking
import retrofit2.converter.gson.GsonConverterFactory

suspend fun main(args: Array<String>) {
    runBlocking {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)
        val list = service.listRepos("octocat")
        println(list)
    }
}