package ncu.edu.cn.bbs.configuration;

import ncu.edu.cn.bbs.entity.User;
import ncu.edu.cn.bbs.utils.ConstantUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/13 20:10
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if(user == null){
//            response.sendRedirect(request.getContextPath()+"/");
            response.sendRedirect("/");

//            //重定向
//            request.getRequestDispatcher("/").forward(request, response);
            return false;

        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
