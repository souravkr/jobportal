<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<style>

.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table th,
.styled-table td {
    padding: 12px 15px;
}

.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}



</style>

<body>

<center><h2> GetAJob.com </h2></center>

<hr/><br>

Welcome to GetAJob.com! Were your dream job is a click  away!

<form:form action="getJobs" modelAttribute="company">

<%--    <form:select path="companyName" >
      <c:forEach var="theUser" items="${companies}">
         <form:option value="${theUser}" label="${theUser}"/>
      										
   </form:select>
 --%>
 
 <h2>Select the Company to get the Job LIst</h2>
 
 <br><br>
 <form:select path="companyName">  
 
  <form:option value="ALL" label="ALL"/> 
 <c:forEach var="theUser" items="${companies}">
 
        <form:option value="${theUser}" label="${theUser}"/>  
  
       
 </c:forEach>	
 
  </form:select>  
        <input type="submit"/>
        
<br><br>
 										
</form:form> 





<c:if test="${jobs != null}">	
										
<table class="styled-table">
    <thead>
        <tr>
            <th>Job ID</th>
            <th>Role</th>
            <th>Company Name</th>
            <th>Salary Offered</th>
        </tr>
    </thead>
    <tbody>
    
    <c:forEach var="temp" items="${jobs}">
        <tr>
            <td>${temp.id}</td>
            <td>${temp.role}</td>
            <td>${temp.company}</td>
            <td>${temp.salary}</td>
            
            <td>
            
<c:url var="tempDelete" value="/applyJob">
<c:param name="jid" value="${temp.id}"></c:param>
</c:url>

<a href="${tempDelete}">Apply For this Job</a>
  
  </td>
  
            
        </tr>
        
      </c:forEach>
       
    </tbody>
</table>

</c:if>

<a href="${pageContext.request.contextPath}/postJob">Post Your Own Job</a>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input type="submit" value="Log Out"/>

</form:form>
</body>
</html>