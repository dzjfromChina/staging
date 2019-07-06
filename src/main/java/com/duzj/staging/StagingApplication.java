package com.duzj.staging;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.duzj.staging.dao")//dao层接口
public class StagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StagingApplication.class, args);
	}


	/**
	 * fastjosn配置
	 * 如果在springboot想使用fastjson 就得加这个
	 *
	 * 建议还是不要用fsatjson了,如果默认是fastjson controller层接受到的json字符串的里面的顺序和前端会不一致
	 *
	 * 如果加密方式采用了md5并且是对参数加密 会导致前后加密不一致!
	 *
	 * fastjson目前我没找到全局配置,但是单个json可以通过fastjson并且通过参数配置可以不排序
	 *
	 * @return
	 */
	 /*   @Bean
		public HttpMessageConverters fastJsonHttpMessageConverters() {
			FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
			FastJsonConfig fastJsonConfig = new FastJsonConfig();
			fastJsonConfig.setFeatures(Feature.OrderedField);
			//SerializerFeature.config(SerializerFeature.WRITE_MAP_NULL_FEATURES,);
			fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
			converter.setFastJsonConfig(fastJsonConfig);
			return new HttpMessageConverters(converter);
		}*/

}
