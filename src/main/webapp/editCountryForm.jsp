<%@ page isELIgnored="false"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.cfg.Configuration" %>
<%@page import="java.util.List" %>
<%@page import="javax.persistence.Query" %>
<%@page import="com.hibernate.models.Country" %>
<%@page import="com.hibernate.models.City" %>
<%@page import="com.hibernate.models.Language" %>
<%@page import="com.hibernate.models.Sports" %>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Edit Form</title>
</head>
<body>

<%
int id=Integer.parseInt(request.getParameter("id"));
SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
Session session1 = sessionFactory.openSession();
Country p = session1.get(Country.class, id);

String hql = "FROM com.hibernate.models.Sports";
Query query_sports = session1.createQuery(hql);
List<Sports> sports = query_sports.getResultList();
request.setAttribute("sports",sports);


String hq2 = "FROM com.hibernate.models.Language";
Query query_language = session1.createQuery(hq2);
List<Language> languages = query_language.getResultList();
request.setAttribute("languages",languages);


String hq3 = "FROM com.hibernate.models.City";
Query query_city = session1.createQuery(hq3);
List<City> city = query_city.getResultList();
request.setAttribute("city",city);
%>

<h1>Edit Country Details</h1>
<form action="editDetails" method="post">
<input type="hidden" name="id" value="<%=p.getId() %>"/>
<table>

<tr>
	<td>Name:</td>
	<td><input type="text" name="productname" value="<%= p.getName()%>"/></td>
</tr>
<tr>
	<td>Language</td>

    <td><select name="languages" d>
    <option value="none" selected disabled hidden>Select an Language</option>
        <c:forEach items="${languages}" var="languages">
            <option value="${languages.id}">${languages.languageName}</option>
        </c:forEach>
    </select></td>
	
</tr>


<tr>
	<td>Sports</td>

    <td><select name="country_sports"  multiple>
    <option value="none" selected disabled hidden>Select Sports</option>
        <c:forEach items="${sports}" var="sports">
            <option value="${sports.id}">${sports.sportName}</option>
        </c:forEach>
    </select></td>
	
</tr>

<tr>
	<td>Capital</td>

    <td><select name="capitalCity" >
    <option value="none" selected disabled hidden>Select an Capital City</option>
        <c:forEach items="${city}" var="city">
            <option value="${city.id}">${city.name}</option>
        </c:forEach>
    </select></td>
	
</tr>

<tr>

	<td colspan="2"><input type="submit" value="Edit Product"/></td>
</tr>
</table>
</form>

</body>
</html>