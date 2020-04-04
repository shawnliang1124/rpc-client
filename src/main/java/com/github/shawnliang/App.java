package com.github.shawnliang;

import com.github.shawnliang.client.RpcProxyClient;
import com.github.shawnliang.config.SpringConfig;
import com.github.shawnliang.dto.UserDto;
import com.github.shawnliang.service.IHelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/3/31
 */
public class App {

  public static void main(String[] args) {
    // 通过动态代理实例化，远程代理
//    IHelloService iHelloService = RpcProxyClient
//        .clientProxy(IHelloService.class, "localhost", 8080);
//
//    UserDto userDto = new UserDto();
//    userDto.setAge(20);
//    userDto.setName("张三");
//    iHelloService.saveUser(userDto);
//    String hello = iHelloService.sayHello("hi mike");
//    System.out.println(hello);

    ApplicationContext context = new
        AnnotationConfigApplicationContext(SpringConfig.class);
    RpcProxyClient proxyClient = context.getBean(RpcProxyClient.class);

    IHelloService iHelloService = proxyClient
        .clientProxy(IHelloService.class, "localhost", 8080);

//    UserDto userDto = new UserDto();
//    userDto.setAge(20);
//    userDto.setName("张三");
//    iHelloService.saveUser(userDto);
//    String hello = iHelloService.sayHello("hi mike");
//    System.out.println(hello);
    iHelloService.sayHello("你好啊");
  }

}
