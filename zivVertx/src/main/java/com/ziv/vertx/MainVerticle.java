package com.ziv.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle{

	@Override
	public void start() throws Exception{
		vertx.createHttpServer().requestHandler(handler->{
			
		}).listen(8800, res->{
			System.out.println("--");
		});
	}
	
	public static void main(String[] args) {
		Vertx.vertx().deployVerticle(new MainVerticle());
	}
}
