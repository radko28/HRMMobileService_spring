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
	<%-- <form:hidden path="created"/> --%>
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
			<td colspan="2"> <form:errors path="oldpassword" cssClass = "errortext" /></td>
		</tr>
    	<tr>
			<td></td>
			<td></td>
    		<td><label for="password"><spring:message code="password.new"/> *</label></td>
			<td><form:password path="password" /></td>
		</tr><tr>
		<tr>
			<td colspan="2"><%-- <form:errors path="birthdateString" cssClass = "errortext" /> --%></td>
			<td colspan="2"><form:errors path="password" cssClass = "errortext" /></td>
		</tr>
    	<tr>
    		<td></td>
    		<td style="padding-right: 20px;"><input type="submit" name="changeProfile" value="<spring:message code="button.changeProfile" />"/></td>
    		<td><label for="confirm"><spring:message code="password.new.confirm" /> *</label></td>
			<td><form:password path="confirm" /></td>
		</tr>
		<tr>
			<td colspan="3"></td>
			<td><input type="submit" name="changePassword" value="<spring:message code="button.changePassword" />"/></td>
		</tr>
	</table>
	
  </form:form>
     <p><a href="<c:url value='/user/editUser?userId=${user.userId}' />"><spring:message code="link.edit"/></a></p>	
</body>
</html>
