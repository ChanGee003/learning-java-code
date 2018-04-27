package com.ziv.vertx;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;

public class VertxMain {

	
	public static void main(String[] args) {
		Vertx.vertx().createHttpServer().requestHandler(req->{
			if(!"/favicon.ico".equals(req.uri())){
				switch (req.method()) {
				case GET:
					MultiMap params = req.params();
					System.out.println("收到请求："+req.absoluteURI()+",参数："+params.toString());
					break;
					
				case POST:
					req.bodyHandler(bodybuffer->{
						System.out.println("收到请求："+req.absoluteURI()+",参数："+bodybuffer.toString());
					});
					break;
					
				default:
					break;
				}
			};
			req.response().end("response content");
		}).listen(8099,res->{
			if(res.succeeded()){
				System.out.println("server listen over "+res.result().actualPort());
			}else{
				System.out.println("server fail "+res.cause());
			}
		});
	}
	
	
}
