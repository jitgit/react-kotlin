package org.learning

import ratpack.jackson.Jackson.json
import ratpack.server.RatpackServer
import ratpack.server.ServerConfig
import org.learning.service.SearchService


class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val service = SearchService()
            RatpackServer.start { server ->
                server
                    .serverConfig(ServerConfig.embedded().port(5000))
                    .handlers { chain ->
                        chain
                            .prefix("api") { api ->
                                api.all { ctx ->
                                    val headers = ctx.getResponse().getHeaders()
                                    headers.set("Access-Control-Allow-Origin", "*")
                                    headers.set("content-type", "application/json")
                                    headers.set("Accept-Charset", "UTF-8")
                                    ctx.next()
                                }
                                    .get("search/:s") { ctx ->
                                        val s = ctx.pathTokens["s"].toString()
                                        println("Search for $s ...")
                                        val result = service.search(s)
                                        ctx.render(json(result))
                                    }
                            }

                    }
            }
        }
    }
}




