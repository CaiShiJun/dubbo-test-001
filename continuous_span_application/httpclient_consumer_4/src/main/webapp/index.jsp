<html>
<body>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<li><a href="<%=contextPath%>/httpClientConsumer/returnServiceLink" target="_blank">dubbo-->grpc-->thrift-->httpclient</a></li>

</body>
</html>
