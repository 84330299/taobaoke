1.配置Maven环境变量
	1.新建环境变量 MAVEN-HOME	-D:\tools\apache-maven-3.5.0
	2.path配置MAVEN			%MAVEN-HOME%\bin;
	
2.将jar安装到本地仓库
	mvn install:install-file -Dfile=E:/taobao-sdk-java-auto_1508127863586-20171016.jar -DgroupId=com.taobao.apis -DartifactId=taobao-sdk -Dversion=1.0.0 -Dpackaging=jar
	
3.服务器运行 xx.jar
	cmd ->  java -jar xx.jar  即可运行springboot项目
	localhost:1234/swagger-ui.html

==========================================
关于配置文件 tbk.properties


淘宝客请求地址： 
BASE_URL =http://gw.api.taobao.com/router/rest

淘宝客应用key： 
APP_KEY = 24656274

淘宝客应用密钥： 
APP_SECRET = e66c706e7c6d1a15840358ce5806067f

推广编号：mm_xxx_xxx_xxx的第三位
AdzoneId= 142282254

淘宝客账户编号：
UserId = 53194273

推广编号：
PID = 	mm_10983931_38282546_142282254

==========================================
keytool -genkey -v -keystore 5igogogo.keystore -alias 5igogogo -keyalg RSA -validity 20000 -keystore /Users/chen/Desktop/keystore/5igogogo.keystore;


	
		