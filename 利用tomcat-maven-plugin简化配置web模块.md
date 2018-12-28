配置tomcat7-maven-plugin插件
```
<plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>${tomcat-plugin-version}</version>
                <configuration>
                    <port>8087</port>
                    <path>/</path>
                </configuration>
            </plugin>
        </plugins>
```

用命令`mvn tomcat:run`运行一次，idea就自行生成一个module了，这时还是缺少web.xml
在main目录创建
```
main
    webapp
        WEB-INFO
            web.xml
        index.html
```

然后在module的配置中指定Deployment Descriptors为web.xml即可以，见截图

项目见目录下的 tomcat-maven-plugin