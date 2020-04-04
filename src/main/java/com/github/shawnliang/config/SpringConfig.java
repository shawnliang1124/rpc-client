package com.github.shawnliang.config;

import com.github.shawnliang.client.RpcProxyClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/4/5
 */
@Configuration
@ComponentScan("com.github.shawnliang")
public class SpringConfig {

  @Bean("rpcProxyClient")
  public RpcProxyClient rpcProxyClient() {
    return new RpcProxyClient();
  }

}
