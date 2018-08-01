<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
<body>
<h2>生产者</h2>

<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-dubbo-provider" target="_blank">dubbo基于Dubbo协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-rmi-provider" target="_blank">dubbo基于Rmi协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-http-provider" target="_blank">dubbo基于Http协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-hessian-provider" target="_blank">dubbo基于Hessian协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-webservice-provider" target="_blank">dubbo基于webservice协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-thrift-provider" target="_blank">dubbo基于thrift协议的跨应用（暂不支持跨应用）</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-memcached-provider" target="_blank">dubbo基于memcached协议的跨应用（暂不支持跨应用）</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-redis-provider" target="_blank">dubbo基于redis协议的跨应用（暂不支持跨应用）</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-mina-provider" target="_blank">dubbo基于mina的传输协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-grizzly-provider" target="_blank">dubbo基于grizzly的传输协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboProviderController/dubboDefaultProviderMethod?agreements=dubbo-callback-provider" target="_blank">dubbo基于callback模式的跨应用</a></li>

</body>
</html>
