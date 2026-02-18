<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<body>
	<c:set var="age" scope="session" value="${11}">
	<c:out value="${age}" />
</body>
</html>
