<%@ include file="/webresources/header.jspf"%>
    <h1>Update city</h1>
    <form role="form" action="${contextPath}/city/update" method="POST">
        <div class="form-group">
            <label for="id">Id</label>
            <input class="form-control" type="number" name="id" readonly value="${city.id}" autocomplete="off" />
        </div>
        <div class="form-group">
            <label for="text">City</label>
            <input class="form-control" type="name" name="name" value="${city.name}" autocomplete="off" />
        </div>
        <button type="submit" class="btn btn-success"><i class="fa fa-check fa-fw"></i>Save</button>
        <a href="${pageContext.request.contextPath}/city" class="btn btn-danger"><i class="fa fa-times fa-fw"></i>Cancel</a>
    </form>
<%@ include file="/webresources/footer.jspf"%>
