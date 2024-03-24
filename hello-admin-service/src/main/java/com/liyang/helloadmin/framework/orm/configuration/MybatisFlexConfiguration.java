package com.liyang.helloadmin.framework.orm.configuration;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.logicdelete.LogicDeleteProcessor;
import com.mybatisflex.core.logicdelete.impl.TimeStampLogicDeleteProcessor;
import com.mybatisflex.core.mybatis.FlexConfiguration;
import com.mybatisflex.spring.boot.ConfigurationCustomizer;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class MybatisFlexConfiguration implements MyBatisFlexCustomizer, ConfigurationCustomizer {

  @Override
  public void customize(FlexGlobalConfig flexGlobalConfig) {
    // TODO
  }

  @Override
  public void customize(FlexConfiguration flexConfiguration) {
    flexConfiguration.setLogImpl(StdOutImpl.class);
  }

  @Bean
  public LogicDeleteProcessor logicDeleteProcessor() {
    return new TimeStampLogicDeleteProcessor();
  }
}
