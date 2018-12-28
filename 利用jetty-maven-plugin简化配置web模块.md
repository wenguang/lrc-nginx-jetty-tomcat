配置插件
```
<build>
        <plugins>
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>${jetty-version}</version>
                <configuration>
                    <httpConnector>
                        <host>localhost</host>
                        <port>8088</port>
                    </httpConnector>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

mvn:jetty:run后不像tomcat-maven-plugin一样自行生成一个web模块，没关系，动手建一个就是，见目录下截图
在main目录创建
```
main
    webapp
        WEB-INFO
            web.xml
        index.html
```

把Deployment Descritpors和Web Resource Directory设置对即可