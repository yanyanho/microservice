package com.example.demogateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanyanho on 2017/7/4.
 */
public class PrintFilter extends ZuulFilter {

        private static Logger log = LoggerFactory.getLogger(PrintFilter.class);

        @Override
        public String filterType() {
            return "pre";
        }

        @Override
        public int filterOrder() {
            return 1;
        }

        @Override
        public boolean shouldFilter() {
            return true;
        }

        @Override
        public Object run() {

            RequestContext ctx = RequestContext.getCurrentContext();

            HttpServletRequest request = ctx.getRequest();

            log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));


            // get name
            //socket session
        //    1auto - session -返回 token request sai ru session
          //          2 token  session id
           // (sessionId, auth)
            ctx.addZuulRequestHeader("Authorization","");
            return null;
        }
}


