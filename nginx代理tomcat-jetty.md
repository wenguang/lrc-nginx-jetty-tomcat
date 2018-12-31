让请求都经过nginx，静态资源由nginx自身处理，动态资源转发给tomcat/jetty，经过处理后返回给nginx，再由nginx返回给客户端.
```
server {
        listen       80;
        server_name  localhost;

        location ~ \.(js|css|html|jpg|png|gif|zip|rar)$ {
            root html;
        }

        location / {
            proxy_pass http://127.0.0.1:8087;
        }
        #...
```
