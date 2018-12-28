###说在前面
[Jetty官方文档翻译目录](https://www.cnblogs.com/yiwangzhibujian/p/5832294.html) ：虽然只翻译了部分，但以目录为索引搜索学习资料是很有用的方法

jetty.home是jetty是安装目录,jetty9以后有个jetty.base的概念，它让我们可以在做任意的位置建立目录来部署应用，比如建立~/Desktop/jetty-base，cd到该目录下

1、确定为base目录，生成start.d目录，start.d用来留各模块的ini文件 
```
java -jar $JETTY_HOME/start.jar --create-startd
```


2、加入需要的模块，这里只加入http和deploy模块，加入后就能在start.d目录下找到http.ini和deploy.ini文件。`可以java -jar $JETTY_HOME/start.jar --list-all-modules`列出所有模块，这些模块可在$JETTY_HOME/modules下找到
```
java -jar $JETTY_HOME/start.jar --add-to-start=server,http,deploy
```


3、指定端口启动jetty，若不指定端口就用start.d/http.ini配置的，默认为8080
```
java -jar \$JETTY_HOME/start.jar jetty.http.port=8888
```


更多的start.jar的参数用java -jar \$JETTY_HOME/start.jar --help查看

jetty-maven-plugin可以在IDEA上直接运行jetty，当然在项目目录下用mvn jetty:run是一样的效果。我试着把jetty-maven-plugin不放在`<build><plugin>`结点，而是放在`<dependency>`下，可以看到下载到jar包很多，有jetty-server、jetty-webapp...一堆，就相当是一个完整的jetty了。以下是简单的配置就可以让它跑起来

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
                        <port>8888</port>
                    </httpConnector>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

