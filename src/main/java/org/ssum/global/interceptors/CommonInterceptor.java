package org.ssum.global.interceptors;

import jakarta.persistence.Column;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CommonInterceptor implements HandlerInterceptor { //공통적인 인터셉터


    @Override // 모든 컨트롤러 먼저 공통적인 처리 해주는 메서드
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        checkDevice(request);  // 지도 API인지 다른 API인지 체크

        return true;
    }

    /**
     * PC와 Mobile 수동 변환
     * ?device=MOBILE
     * ?device=PC
     *
     * @param request
     */


    private void checkDevice(HttpServletRequest request) {
        String device = request.getParameter("device"); //요청 디바이스가 피씨인지 모바일인지 체크
        if (!StringUtils.hasText(device)) {
            return;
        }
        device = device.toUpperCase().equals("MOBILE") ? "MOBILE" : "PC";

        HttpSession session = request.getSession();
        session.setAttribute("device", device);
    }
}

