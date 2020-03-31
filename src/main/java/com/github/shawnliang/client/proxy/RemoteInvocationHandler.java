package com.github.shawnliang.client.proxy;

import com.github.shawnliang.client.util.RpcNetTransport;
import com.github.shawnliang.request.RpcRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/3/31
 */
public class RemoteInvocationHandler implements InvocationHandler {

  private String host;
  private int port;

  public RemoteInvocationHandler(String host, int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("开始动态代理");

    RpcRequest rpcRequest = new RpcRequest();
    rpcRequest.setClassName(method.getDeclaringClass().getName());
    rpcRequest.setMethodName(method.getName());
    rpcRequest.setParams(args);

    RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
   return rpcNetTransport.send(rpcRequest);
  }
}
