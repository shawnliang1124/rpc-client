package com.github.shawnliang.client;

import com.github.shawnliang.dto.UserDto;
import com.github.shawnliang.service.IHelloService;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/3/31
 */
public class App {

  public static void main(String[] args) {
    // 通过动态代理实例化，远程代理
    IHelloService iHelloService = RpcProxyClient
        .clientProxy(IHelloService.class, "localhost", 8080);

    UserDto userDto = new UserDto();
    userDto.setAge(20);
    userDto.setName("张三");
    iHelloService.saveUser(userDto);
    String hello = iHelloService.sayHello("hi mike");
    System.out.println(hello);
  }

}
