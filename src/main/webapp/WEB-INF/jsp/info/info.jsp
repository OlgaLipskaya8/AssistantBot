<%@ include file="/webresources/header.jspf"%>
    <h1>Info</h1>
    <table class="table table-striped table-bordered">
        <tbody>
            <tr>
                <td>Id</td>
                <td>${info.id}</td>
            </tr>
            <tr>
                <td>Text</td>
                <td>${info.text}</td>
            </tr>
            <tr>
                <td>City</td>
                <td>${info.city.name}</td>
            </tr>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/info/update/${info.id}" class="btn btn-warning"><i class="fa fa-pencil-square fa-fw"></i>Update</a>
    <a href="${pageContext.request.contextPath}/info" class="btn btn-danger"><i class="fa fa-times fa-fw"></i>Back</a>
<%@ include file="/webresources/footer.jspf"%>
