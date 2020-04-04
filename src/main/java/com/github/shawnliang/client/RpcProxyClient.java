package com.github.shawnliang.client;

import com.github.shawnliang.proxy.RemoteInvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/3/31
 */
public class RpcProxyClient {

  public <T> T clientProxy(Class<T> interfaceCls, String host, int port) {
    return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls},
        new RemoteInvocationHandler(host, port));
  }

}
