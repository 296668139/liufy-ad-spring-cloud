package com.liufy.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 继承ZuulFilter,实现自定义网关过滤器
 */
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {
    /**
     * 过滤器的类型（Zuul的生命周期）
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 过滤器执行的顺序，数字越小，优先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    /**
     * 过滤器是否执行（可以在其中进行逻辑判断）
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器执行内容
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Long startTime = (Long) context.get("startTime");
        String uri = request.getRequestURI();
        Long duration = System.currentTimeMillis() - startTime;
        log.info("uri:"+uri+",duration:"+duration/100+"ms");
        return null;
    }
}
