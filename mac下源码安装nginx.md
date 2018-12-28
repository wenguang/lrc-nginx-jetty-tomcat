不想用brew来安装nginx，因为少了掌控力，也不知道brew是怎么安装的，还是用makefile方式安装，和linux的安装一致还是有好处的，生产环境一般都是linux的嘛。

nginx选择了稳定版本1.12.2, nginx及依赖见“nginx1-1.12.2安装文件及依赖”目录

解压、配置、编译、安装 如下：

```
tar -zxvf nginx-1.12.2.tar.gz
tar -zxvf zlib-1.2.11.tar.gz
tar -zxvf pcre-8.42.tar.gz
tar -zxvf openssl-1.1.0g.tar.gz

cd nginx-1.12.2

./configure --sbin-path=/usr/local/nginx/nginx --conf-path=/usr/local/nginx/nginx.conf --pid-path=/usr/local/nginx/nginx.pid --with-http_ssl_module --with-pcre=../pcre-8.42 --with-zlib=../zlib-1.2.11 --with-openssl=../openssl-1.1.0g

sudo make
sudo make install
```

更多用./configure配置安装信息见：http://nginx.org/en/docs/configure.html 

安装好后路径就在 /usr/local/nginx，可招待文件nginx和配置文件nginx.conf就在就该目录，不改配置的话就用80端口

sudo ./nginx            #启动 http://localhost即可访问
sudo ./nginx -s stop    #停止

更多命令参数见：http://nginx.org/en/docs/beginners_guide.html


