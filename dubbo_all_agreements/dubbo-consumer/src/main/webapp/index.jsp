<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
<body>
<h2>消费者</h2>

<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-dubbo-consumer" target="_blank">dubbo基于Dubbo协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-rmi-consumer" target="_blank">dubbo基于Rmi协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-http-consumer" target="_blank">dubbo基于Http协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-hessian-consumer" target="_blank">dubbo基于Hessian协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-webservice-consumer" target="_blank">dubbo基于webservice协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-thrift-consumer" target="_blank">dubbo基于thrift协议的跨应用（暂不支持跨应用）</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-memcached-consumer" target="_blank">dubbo基于memcached协议的跨应用（暂不支持跨应用）</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-redis-consumer" target="_blank">dubbo基于redis协议的跨应用（暂不支持跨应用）</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-mina-consumer" target="_blank">dubbo基于mina的传输协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-grizzly-consumer" target="_blank">dubbo基于grizzly的传输协议的跨应用</a></li>
<li><a href="<%=contextPath%>/DubboConsumerController/dubboDefaultConsumerMethod?agreements=dubbo-callback-consumer" target="_blank">dubbo基于callback模式的跨应用</a></li>

</body>
</html>
