import java.io.IOException;

public class TomcatEmbedded {

    private static final String EMPTY = "";

    public static void main(String... args)
        throws Exception {
            File baseFolder = new File(System.getProperty("user.dir"));
            File appsFolder = new File(baseFolder, child:"apps");

            Tomcat tomcat = new Tomcat();
            tomcat.setBaseDir(baseFolder.getAbsolutePath());
            tomcat.setPort(8080);
            tomcat.getHost().setAppBase(appsFolder.getAbsolutePath());

            tomcat.getConnector();

            tomcat.addWebapp(EMPTY, docbase: ".");
            Wrapper wrapper = tomcat.addServlet(EMPTY, servletName: "hello", new HelloServlet());
            wrapper.setLoadOnStartup(1);
            wrapper.addMapping(s: "/*");

            tomcat.start();
            tomcat.getServer().await();
        }}