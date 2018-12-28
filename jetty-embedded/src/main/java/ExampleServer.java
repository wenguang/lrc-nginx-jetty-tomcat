/**
 * http://www.cnblogs.com/yiwangzhibujian/p/5832597.html
 */

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ExampleServer {

    public static void main( String[] args ) throws Exception
    {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(HelloServlet.class, "/hello");
//        context.addServlet(AsyncEchoServlet.class, "/echo/*");
        HandlerCollection handlers = new HandlerCollection();
        /**
         * 一个Jetty服务器可以只有一个处理程序实例来处理传入的HTTP请求。然而一个处理程序可能是一个容器或包装其他处理程序形成一个树的处理程序。
         * 在etc/jetty.xml文件中配置的默认的处理程序包含处理程序集合和一个默认的处理程序，根据路径找到相应的处理程序，默认的处理器处理404错误。
         * 其他配置信息可以增加到处理树中（例如，jetty-rewrite.xml, jetty-requestlog.xml）， 或者配置一个组件用于热部署处理（例如，jetty-deploy.xml） 。
         */
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);
        server.start();
        server.join();
    }
}
