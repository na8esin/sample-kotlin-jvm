package jwt

import io.jsonwebtoken.Jwts

fun main() {
    val key = Jwts.SIG.HS256.key().build()
    val jws = Jwts.builder().subject("Joe").signWith(key).compact()
    println(jws)
}