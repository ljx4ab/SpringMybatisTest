<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<c:forEach var="test" items="${list}">
        ${test.id}-${test.name}<br>
	</c:forEach>
</body>
</html>