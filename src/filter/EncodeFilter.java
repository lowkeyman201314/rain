package filter;

/**
 * @Author: laoyu
 * @Date: 2020/2/20 17:45
 * @Description:
 */

import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {
    //设置字符集格式的变量
    String myEncode = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取web.xml中的初始化参数
        String encode = filterConfig.getInitParameter("encode");
        System.out.println(encode);
        //如果用户没有设置字符集格式，则使用从web.xml中获取到的字符集格式
        if (myEncode == null) {
            this.myEncode = encode;
        }
        System.out.println(myEncode);

    }

    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {
        //获取字符集格式
        String encoding = servletRequest.getCharacterEncoding();
        if (encoding == null) {
            servletRequest.setCharacterEncoding(myEncode);
        }
        //切记--------------------放行！！！！！！！！
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.myEncode = null;
    }
}

