<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.Date"%>

<%--  request.setAttribute("rtv","rtv="+new Date().getTime());  --%>
 
<c:set var="pagebase"  scope="request"><%=request.getContextPath()%></c:set>
<%--<c:set var="staticbase" scope="request"><%=ImgConstants.STATEIC_BASE%></c:set>
<c:set var="imgbase" scope="request"><%=ImgConstants.IMG_BASE %></c:set>
<c:set var="decimalCount" scope="request"><%=PriceConstants.DECIMAL_COUNT %></c:set>
<c:set var="defaultimg" scope="request"><%=ImgConstants.DEFAULT_IMG_URL %></c:set>
<c:set var="loginUrl" scope="request"><%=CommonUrlConstants.LOGIN_URL %></c:set>
<c:set var="version" scope="request">version=000000</c:set>
<c:set var="title" scope="application"><spring:message code="platform.name" /></c:set>
<c:set var="lang" scope="request">${pageContext.response.locale}</c:set>
--%>