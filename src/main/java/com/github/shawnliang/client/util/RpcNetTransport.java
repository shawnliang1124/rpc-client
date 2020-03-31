package com.github.shawnliang.client.util;

import com.github.shawnliang.request.RpcRequest;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/3/31
 */
public class RpcNetTransport {

  private String host;
  private int port;

  public RpcNetTransport(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public Object send(RpcRequest rpcRequest) {
    Object result;
    try (Socket socket = new Socket(host,
        port); ObjectOutputStream outputStream = new ObjectOutputStream(
        socket.getOutputStream()); ObjectInputStream objectInputStream = new ObjectInputStream(
        socket.getInputStream())) {
      // rpc调用写入请求
      outputStream.writeObject(rpcRequest);
      outputStream.flush();
      //
      result = objectInputStream.readObject();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

}
