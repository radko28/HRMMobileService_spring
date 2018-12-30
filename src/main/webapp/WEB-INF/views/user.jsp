<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>

<body>

<h3>${user.username}</h3>

  <form:form commandName="user" method="post">
	<form:hidden path="userId" />
    <form:hidden path="enabled"/>
    <table>
    	<tr>
			<td><form:label	for="firstname" path="firstname"><spring:message code="users.table.firstname"/> *</form:label></td>
			<td><form:input path="firstname" /></td>
    		<td><form:label	for="username" path="username" ><spring:message code="users.table.username"/></form:label></td>
			<td><form:input path="username" readonly="true" cssStyle="background-color: #e5e5e5; border-color: #ababab;"/></td>
		</tr>
		<tr>
			<td colspan="2"><form:errors path="firstname" cssClass = "errortext" /></td>
			<td colspan="2"><form:errors path="username"  cssClass = "errortext"/></td>
		</tr>
    	<tr>
    		<td><form:label	for="lastname" path="lastname"><spring:message code="users.table.lastname"/> *</form:label></td>
			<td><form:input path="lastname"/></td>		
		</tr>
		<tr>
			<td colspan="2"> <form:errors path="lastname" cssClass = "errortext" /></td>
			<td colspan="2"></td>
		</tr>
	</table>
  </form:form>
     <p><a href="<c:url value='/web/userInfo/editUser?userId=${user.userId}' />"><spring:message code="link.edit"/></a></p>	
</body>
</html>
