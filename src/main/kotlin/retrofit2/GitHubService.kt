package retrofit2

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String?): List<Repo?>?

    /**
     * Callをそのまま扱おうとするとどうなる？
     */
    @GET("users/{user}/repos")
    fun listReposWithCall(@Path("user") user: String?): Call<List<Repo?>?>
}