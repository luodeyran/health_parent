package org.dey.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


/**
 * @author Dey-Ran
 * <p>
 * 关于 AbstractAnnotationConfigDispatcherServletInitializer 在 Servlet 3.0
 * 环境下，Servlet 容器会在 classpath 下搜索实现了 javax.servlet.ServletContainerInitializer
 * 接口的任何类，找到之后用它来初始化 Servlet 容器。
 * <p>
 * Spring 实现了以上接口，实现类叫做 SpringServletContainerInitializer， 它会依次搜寻实现了
 * WebApplicationInitializer的任何类，并委派这个类实现配置。 之后，Spring 3.2 开始引入一个简易的
 * WebApplicationInitializer 实现类， 这就是
 * AbstractAnnotationConfigDispatcherServletInitializer。 所以
 * SpittrWebAppInitializer 继承
 * AbstractAnnotationConfigDispatcherServletInitializer之后， 也就是间接实现了
 * WebApplicationInitializer，在 Servlet 3.0 容器中，它会被自动搜索到，被用来配置 servlet 上下文。
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *  注册顺序->listener->filter(Shiro安全框架)->servlet(SpringMVC)..
     *  必须按照顺序注册,所以必须重写onStarup
     */
/*    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//    	super.onStartup(servletContext);
        registerContextLoaderListener(servletContext);
        // 在这里注册shiro过滤器
        registerSiroFilter(servletContext);

        registerDispatcherServlet(servletContext);
    }*/

    /**
     * 注册过滤器解决post乱码问题
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        filter.setForceEncoding(true);
        return new Filter[]{filter};
    }

    /**
     * 注册shiro配置
     *
     * @param servletContext
     */
/*    private void registerSiroFilter(ServletContext servletContext) {
        // 注册Filter对象
        // 什么时候需要采用此方式进行注册?
        // 项目没有web.xml并且此filter不是自己写的
        FilterRegistration.Dynamic dy = servletContext.addFilter("filterProxy", DelegatingFilterProxy.class);
        dy.setInitParameter("targetBeanName", "shiroFilterFactoryBean");
        dy.addMappingForUrlPatterns(null, // EnumSet<DispatcherType>//不写就是默认所有的.
                false, // 是否精确匹配
                "/*");// url-pattern
    }*/


    /**
     * 此方法负责加载Service和其他第三方包的初始化配置如service层和DataAccessObject层的框架和类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringConfig.class};
    }

    /**
     * 这里写入用以取代Spring和SpringMVC的配置文件
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringmvcConfig.class};
    }

    /**
     * 这里配置默认前端控制器.这里所有匹配*.do的访问都会被捕捉到. 也可以配置为"/" 不会拦截.jsp /* 全部拦截   不能使用.log 结尾，否则阿里巴巴 fastjson转换报错
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
