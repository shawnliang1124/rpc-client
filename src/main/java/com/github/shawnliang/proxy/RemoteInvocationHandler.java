package com.github.shawnliang.proxy;

import com.github.shawnliang.util.RpcNetTransportUtil;
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
    RpcRequest rpcRequest = new RpcRequest();
    rpcRequest.setClassName(method.getDeclaringClass().getName());
    rpcRequest.setMethodName(method.getName());
    rpcRequest.setParams(args);
    rpcRequest.setVersion("v1.0.0");

    RpcNetTransportUtil rpcNetTransportUtil = new RpcNetTransportUtil(host, port);
   return rpcNetTransportUtil.send(rpcRequest);
  }
}
