package com.f1soft.authservice.filters;

import com.f1soft.authservice.exceptionHandler.UnauthorisedException;
import com.f1soft.authservice.utility.JWTTokenUtility;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class TrackingFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return FilterConstants.SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext request = RequestContext.getCurrentContext();

        //IGNORE JWT TOKEN AUTHENICATION FOR LOGIN API
        if (request.toString().startsWith("/login")) {
            return true;
        } else {
            String token = JWTTokenUtility.resolveToken(request);
            if (!Objects.isNull(token) && JWTTokenUtility.validateToken(token)) {
                return true;
            } else {
                throw new UnauthorisedException("Request not authorized, please contact system administrator.",
                        "Unmatched JWT token.");
            }
        }

    }
}
