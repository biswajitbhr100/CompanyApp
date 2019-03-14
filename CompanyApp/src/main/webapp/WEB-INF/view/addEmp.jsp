<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Employee Form</title>
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

  <script>

  $(document).ready(function() {
    $("#datepicker").datepicker({ dateFormat: 'dd/mm/yy' });
  });

  </script> 
 </head>
 <body>
 <center>
  <h2>Create New Employee</h2>
  <form:form method="POST" action="/CompanyApp/saveEmp.html">
      <table>
      	<form:hidden path="empid"/>
       <tr>
           <td><form:label path="empno">Emp ID:</form:label></td>
           <td><form:input path="empno" value="${emp.empno}"/></td>
       </tr>
       <tr>
           <td><form:label path="empname">Emp Name:</form:label></td>
           <td><form:input path="empname" value="${emp.empname}"/></td>
       </tr>
       <tr>
           <td><form:label path="empjob">Emp Job:</form:label></td>
           <td><form:input path="empjob" value="${emp.empjob}"/></td>
       </tr>
       <tr>
           <td><form:label path="empsalary">Emp Salary:</form:label></td>
           <td><form:input path="empsalary" value="${emp.empsalary}"/></td>
       </tr>
       <tr>
           <td><form:label path="empdoj">Emp Doj:</form:label></td>
           <td>
            <fmt:parseDate value="${emp.empdoj}" pattern="yyyy-dd-MM" var="parsedDate" type="date" />
            <fmt:formatDate value="${parsedDate}" var="dojString" pattern="dd/MM/yyyy" type="date" />
           	<form:input path="empdoj" value="${dojString}" id="datepicker"/>
           </td>
       </tr>
      <tr>
        <td>
         <form:label path="dept.deptno">Department:</form:label>
        </td>
        <td>
         <form:select path="dept.deptno" cssStyle="width: 150px;">    
       		<option value="-1">Select dept</option>
       			<c:forEach items="${depts}" var="dept">
        			<option value="${dept.deptno}">${dept.deptno}</option>
       			</c:forEach>
      	</form:select>
     	</td>
       </tr>
       <tr>
         <td>&nbsp;</td>
         <td><input type="submit" value="SAVE"/></td>
        </tr>
   </table> 
  </form:form>
  <br/>
  <c:if test="${!empty emps}">
 <table align="center" border="1">
  <tr>
   <th>EMPNO</th>
   <th>NAME</th>
   <th>DESIGNATION</th>
   <th>SALARY</th>
   <th>DATE OF JOINING</th>
   <th>DEPARTMENT</th>
   <th>OPTIONS</th>
  </tr>

  <c:forEach items="${emps}" var="emp">
   <tr>
    <td><c:out value="${emp.empno}"/></td>
    <td><c:out value="${emp.empname}"/></td>
    <td><c:out value="${emp.empjob}"/></td>
    <td><c:out value="${emp.empsalary}"/></td>
    <td><c:out value="${emp.empdoj}"/></td>
    <td><c:out value="${emp.dept.deptno}"/></td>
    <td align="center">
    	<a href="editEmp.html?empid=${emp.empid}">Edit</a> | <a href="deleteEmp.html?empid=${emp.empid}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
<h2><a href="addDept.html">Go To Department</a></h2>
</center>
 </body>
</html>