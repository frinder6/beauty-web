<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<script type="text/javascript">
	window.location = '<%=basePath%>/common/forward/login-new.action';
</script>