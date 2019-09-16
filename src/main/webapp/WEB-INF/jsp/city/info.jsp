<%@ include file="/webresources/header.jspf"%>
    <h1>City</h1>
    <table class="table table-striped table-bordered">
        <tbody>
            <tr>
                <td>Id</td>
                <td>${city.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${city.name}</td>
            </tr>
        </tbody>
    </table>
    <h1>Info list</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Text</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "info" items="${infoList}">
            <tr>
                <td>${info.text}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/city/update/${city.id}" class="btn btn-warning"><i class="fa fa-pencil-square fa-fw"></i>Update</a>
    <a href="${pageContext.request.contextPath}/city" class="btn btn-danger"><i class="fa fa-times fa-fw"></i>Back</a>
<%@ include file="/webresources/footer.jspf"%>
