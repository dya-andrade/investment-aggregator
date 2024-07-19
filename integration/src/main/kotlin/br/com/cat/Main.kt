package br.com.cat

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

fun main() {
    val clientService = HttpClientService()

    runBlocking {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val posts: List<Post> = clientService.get(url)
        posts.forEach { println(it) }
    }

    clientService.close()
}

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)