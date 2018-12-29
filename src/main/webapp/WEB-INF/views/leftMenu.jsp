<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
  <table class="example"  >
	   <tr>
		<th><a href="<c:url value="/web/userInfo/admin/userList"/>"><spring:message code="link.users"/></a></th>		
	   </tr>
   	   <tr>
		<th><a href="<c:url value="/web/userInfo/currentHRM"/>"><spring:message code="link.currentHRM"/></a></th>		
	   </tr>
	   <tr>
		<th><a href="<c:url value="/web/userInfo/hystoryHRM"/>"><spring:message code="link.historyHRM"/></a></th>
	   </tr>
  </table>

