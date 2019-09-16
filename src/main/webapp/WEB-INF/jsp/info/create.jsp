<%@ include file="/webresources/header.jspf"%>
    <h1>New car</h1>
    <form role="form" action="${contextPath}/info/create" method="POST">
        <div class="form-group">
            <label for="text">Text</label>
            <input class="form-control" type="text" name="text" path="text" autocomplete="off" />
        </div>
        <div class="form-group">
            <label for="city">City</label>
            <select path="city" name="city" class="form-control" id="account">
                <c:forEach var="city" items="${cityList}">
                    <option value="${city.id}">${city.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success"><i class="fa fa-check fa-fw"></i>Save</button>
        <a href="${pageContext.request.contextPath}/info" class="btn btn-danger"><i class="fa fa-times fa-fw"></i>Cancel</a>
    </form>
<%@ include file="/webresources/footer.jspf"%>
