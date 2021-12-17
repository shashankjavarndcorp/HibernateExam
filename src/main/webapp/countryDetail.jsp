<%@ page  isELIgnored="false"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.cfg.Configuration" %>
<%@page import="java.util.List" %>
<%@page import="javax.persistence.Query" %>
<%@page import="com.hibernate.models.Country" %>>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>

<h1>Product Details</h1>

<%
SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
Session session1 = sessionFactory.openSession();
String hql = "FROM com.hibernate.models.Country";
Query query = session1.createQuery(hql);
List<Country> countries = query.getResultList();
request.setAttribute("countries",countries);
%>

<table border="1">
<tr>
<td>id</td>
<td>Country Name</td>
<td>Language</td>
<td>Capital</td>
<td>Sports</td>
<td>EditAction</td>
</tr>


<c:forEach items="${countries}" var="country">
    <tr>      
        <td>${country.getId()}</td>
        <td>${country.getName()}</td>
        <td>${country.getLanguage()}</td>
        <td>${country.getCapital()}</td>
        <td>${country.getSports()}</td>  
       	<td><a href="editCountryForm.jsp?id=${country.getId()}">Edit</a></td>
    </tr>
</c:forEach>

</table>
</body>
</html>