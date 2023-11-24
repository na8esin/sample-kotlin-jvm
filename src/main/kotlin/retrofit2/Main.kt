package retrofit2

import kotlinx.coroutines.runBlocking
import java.io.IOException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var retrofit: Retrofit? = retrofitBuild()
    var service = retrofit?.create(GitHubService::class.java)

    runBlocking {
        val list = try {
            // ここがsuspend
            service?.listRepos("octocat")
        } catch (e: IOException) {
            println(e.message)
        } catch (e: HttpException) {
            println(e.message)
        }

        println(list)
    }
    println("end.")
    // ここまで出力されるけど、いつまでたってもプロセスが終了しない
    // asyncにしてもlaunchにしてもだめ

    service = null
    retrofit = null

    exitProcess(0)
}