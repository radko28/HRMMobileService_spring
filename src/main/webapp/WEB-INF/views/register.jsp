<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>

	<h3><spring:message code="users.create.legend" /></h3>
    <form:form commandName="user" method="post">
	<fieldset>
    <table style="padding-left: 10px; padding-right: 10px;">
    	<tr>
    		<td><form:label	for="username" path="username"><spring:message code="users.table.username"/> *</form:label></td>
			<td style="padding-right: 10px;"><form:input path="username" /></td>
			<td><form:label	for="firstname" path="firstname"><spring:message code="users.table.firstname"/> *</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td colspan="2"><form:errors path="username" cssClass = "errortext"/></td>
			<td colspan="2"><form:errors path="firstname" cssClass = "errortext" /></td>
		</tr>
    	<tr>
    		<td><form:label	for="password" path="password"><spring:message code="password"/> *</form:label></td>
			<td><form:password path="password"/></td>
    		<td><form:label	for="lastname" path="lastname"><spring:message code="users.table.lastname"/> *</form:label></td>
			<td><form:input path="lastname"/></td>		
		</tr>
		<tr>
			<td colspan="2"><form:errors path="password" cssClass = "errortext" /></td>
			<td colspan="2"> <form:errors path="lastname" cssClass = "errortext" /></td>
		</tr>
    	<tr>
    		<td><label for="confirm"><spring:message code="confirm.password"/> *</label></td>
			<td><form:password path="confirm"/></td>
		</tr><tr>
		<tr>
			<td colspan="2"><form:errors path="confirm" cssClass = "errortext" /></td>
		</tr>
		<!-- tr>
			<td>Administrator</td>
			<td colspan="3">
				<form:checkbox path="role" value = "checked" checked="${role}" />
			</td>
		</tr-->
    	<tr>
    		<td colspan="2" style="text-align: right;"><input type="submit" name="action" value="<spring:message code="button.save" />"/></td>
		 	<td colspan="2"><input type="submit" name="_cancel" value="<spring:message code="link.back" />"/></td>
		</tr>
	</table>
    </fieldset>
    </form:form>
</div>
</body>
</html>
