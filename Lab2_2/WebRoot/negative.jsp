 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
  
  <html>
    <head>
      <title>显示代数和</title>
    </head>
    
    <body>
      代数和为负数，怕了吧<h1><s:property value="sum" /></h1>
      <input type="button" value="返回" onClick="window.location.href='<%=request.getContextPath()%>/a.jsp'">
    </body>
  </html> 