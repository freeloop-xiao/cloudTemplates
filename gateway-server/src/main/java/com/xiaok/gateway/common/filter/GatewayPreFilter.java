package com.xiaok.gateway.common.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.gateway.common.verity.VerifyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * author: xiao
 * date:   2019/2/1
 * desc:
 */
@Component
public class GatewayPreFilter extends ZuulFilter {


    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private static final String LOGIN_URL = "/user/api/v1/login";

    private static final String REFRESH_URL = "/user/api/v1/refresh";

    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private VerifyClient verifyClient;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        if (uri.contains(LOGIN_URL) || uri.contains(REFRESH_URL)) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader(AUTHORIZATION);
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.getResponse().setContentType(CONTENT_TYPE);
            ctx.setResponseBody(JSON.toJSONString(new ResultMessage<>("0001", "token未传!")));
        }

        ResultMessage<String> verify = verifyClient.verify(token);
        if (!verify.success()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.getResponse().setContentType(CONTENT_TYPE);
            ctx.setResponseBody(JSON.toJSONString(verify));
        }
        return null;
    }
}
