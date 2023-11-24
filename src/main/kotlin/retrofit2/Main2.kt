package retrofit2

import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

/**
 * Callのまま扱うとどうなるのか？
 */
fun main(args: Array<String>) {
    val service = retrofitBuild().create(GitHubService::class.java)

    val repos = service.listReposWithCall("octocat")

    // 同期的にリクエストできるらしい
    // androidのメインスレッドでは使えないだろうけど。
    val response = repos.execute()
    val body = response.body()
    body?.forEach {
        println(it)
    }

    // これをすればプロセスは終了する
    exitProcess(0)
}