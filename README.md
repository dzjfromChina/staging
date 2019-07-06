# staging

基于SpringBoot2.0 + MyBatis Plus后台脚手架 

# 项目启动
1. IDEA通过github插件下载到本地  
2. 本地新建数据库test 更改yml里面本地数据库的账户密码  
3. 导入sql文件夹下面的表以及数据  

# 功能简介
1. 集成了hutool https://hutool.cn/docs/#/ 
2. 新增JAVA缓存  
    com.duzj.staging.base.cache.DemoCache.java 是一个缓存类  
    com.duzj.staging.base.servletstart.StartupLoading.java 项目启动时候加载数据(缓存等)  
    TestController中的test 有对缓存的测试  
![打包第二步](https://github.com/dzjfromChina/staging/blob/master/readmefile/3.png)   
3. 新增redis支持 demo在TestController的test方法  

# 项目打包
IDEA MAVEN插件进行打包  
其实就是mvn clean package    
![打包第一步](https://github.com/dzjfromChina/staging/blob/master/readmefile/1.png)  
![打包第二步](https://github.com/dzjfromChina/staging/blob/master/readmefile/2.png)  
