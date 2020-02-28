<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Add Employee Form</title>
    <style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
 
<body>
    <h2><spring:message code="lbl.page" text="Add New User" /></h2>
    <br/>
    <form:form method="post" modelAttribute="user">
        <%-- <form:errors path="*" cssClass="error" /> --%>
        <table>
            <tr>
                <td><spring:message code="lbl.Name" text="Name" /></td>
                <td><form:input path="Name" /></td>
                <td><form:errors path="Name" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.Password" text="Password" /></td>
                <td><form:input path="Password" /></td>
                <td><form:errors path="Password" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.email" text="Email Id" /></td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add User"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>