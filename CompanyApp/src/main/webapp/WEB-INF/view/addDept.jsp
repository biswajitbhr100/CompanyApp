<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Department Page</title>
  <style type="text/css">
	.error {
		color: red;
	}
</style>
 </head>
 <body><center>
  <h2>Create New Department</h2>
  <form:form method="POST" action="/CompanyApp/saveDept.html" modelAttribute="dept">
      <table>
       <form:hidden path="deptid"/>	
       <tr>
           <td><form:label path="deptno">Dept No:</form:label></td>
           <td>
           	<form:input path="deptno" value="${dept.deptno}"/>
           	<form:errors path="deptno" cssClass="error" />
         
           </td>
       </tr>
       <tr>
           <td><form:label path="deptname">Dept Name:</form:label></td>
           <td>
           	<form:input path="deptname" value="${dept.deptname}"/>
           	<form:errors path="deptname" cssClass="error" />
           </td>
       </tr>
       <tr>
       <tr>
        <td>&nbsp;</td>
         <td><input type="submit" value="SAVE"/></td>
         </tr>
   </table> 
  </form:form>
  <br/>
  <c:if test="${!empty depts}">
 	<table align="center" border="1">
  		<tr>
   			<th>Dept No.</th>
   			<th>Dept Name</th>
   			<th>Options</th>
  		</tr>

  <c:forEach items="${depts}" var="dept">
   <tr>
    <td><c:out value="${dept.deptno}"/></td>
    <td><c:out value="${dept.deptname}"/></td>
    <td align="center"><a href="editDept.html?deptid=${dept.deptid}">Edit</a> | 
    <a href="deleteDept.html?deptid=${dept.deptid}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
<h2><a href="addEmp.html">Add Employee</a></h2>
</center>
 </body>
</html>